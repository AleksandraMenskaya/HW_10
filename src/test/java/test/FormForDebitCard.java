package test;

import static com.codeborne.selenide.Selenide.sleep;
import data.BirthdayArgumentProvider;
import data.URLsForTestDesign;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormForDebitCard extends TestBaseTinkoff {
    @DisplayName("Валидация поля Дата рождения")
    @Tag("FormForDebitCard")
    @Tag("negative")
    @ArgumentsSource(BirthdayArgumentProvider.class)
    @ParameterizedTest(name = "Для даты {0} текст валидации должен быть {1}")
    void successfulSendFormForDebitCard(String birthday, String ValidationText) {
        open("/cards/debit-cards/tinkoff-black/");
        $("#form").scrollIntoView(true);
        $("div[data-qa-type=\"uikit/input.inputBox.main\"").click();
        $("input[name=\"birthdate\"]").setValue(birthday).pressEnter();
        $("div[data-qa-type=\"uikit/formRow.errorBlock\"]").shouldHave(exactText(ValidationText));
    }

    @DisplayName("Локализация страницы для определенного url")
    @Tag("FormForDebitCard")
    @Tag("positive")
    @CsvSource(value = {
            "cards/debit-cards/tinkoff-black/foreign/kg/ , Россияда жашоо жана иштөө үчүн ыңгайлуу карта",
            "cards/debit-cards/tinkoff-black/foreign/uz/ , Rossiyada yashash va ishlash uchun qulay karta",
            "cards/debit-cards/tinkoff-black/foreign/eng/ , Convenient card for your life and work in Russia",
            "cards/debit-cards/tinkoff-black/foreign/am/ , Հարմար քարտ Ռուսաստանում ապրելու և աշխատելու համար",
            "cards/debit-cards/tinkoff-black/foreign/tj/ , Корти қулай барои ҳаёт ва кор дар Русия",
    })
    @ParameterizedTest(name = "Для url {0} текст заголовка должен быть {1}")
    void CheckLanguage (String UrlLocal, String ValidationText) {
        open(UrlLocal);
        $("div[class=\"application\"]").shouldHave(text(ValidationText));
    }

    @DisplayName("Первый элемент поисковой выдачи содержит текст запроса")
    @Tag("positive")
    @Tag("FormForDebitCard")
    @ParameterizedTest(name = "Если искать {0}, то первый элемент в поисковой выдачи будет {0}")
    @ValueSource(strings = {
            "Как скачать приложение",
            "Как написать в чат",
            "Кэшбэк",
            "Перевод"
    })
    void checkOutPut(String textSearch){
        open("help/");
        $("[data-qa-type=\"uikit/popover.children\"]").click();
        $("[data-qa-type=\"uikit/popover.children\"] input[type=\"text\"]").setValue(textSearch).pressEnter();
        sleep(10000);
        $("[data-qa-type=\"uikit/dropdown.item\"]").shouldHave(text(textSearch));
    }

    @DisplayName("Проверка заголовков страницы для тоглов с указанием возраста")
    @Tag("positive")
    @Tag("FormForDebitCard")
    @CsvSource(value = {
            "1, Дебетовую Tinkoff Black можно получить с 14 лет. Копи и получай кэшбэк до 30% за покупки",
            "2, Получайте кэшбэк в рублях за траты в ресторанах, кино, супермаркетах, магазинах одежды",
            "3, Получайте кэшбэк рублями, а не бонусами за покупки для всей семьи и только для себя. Оплачивайте ЖКУ и другие услуги без комиссии",
            "4, Возвращаем до 15% за продукты, товары для здоровья и дома. Без комиссии за снятие наличных в банкоматах Тинькофф, оплата ЖКУ и связи"
    })
    @ParameterizedTest(name = "Для cssSelector {0} текст заголовка должен быть {1}")
    void CheckText (String number, String ValidText) {
        String xPath = "//label[span[input[@data-qa-type=\"uikit/radio.input\"]]][" + number + "]";
        open("/cards/debit-cards/tinkoff-black");
        $(By.xpath(xPath)).click();
        $("[data-qa-type=\"uikit/button.content\"]").click();
        $("[data-test=\"htmlTag subtitle\"]").shouldHave(text(ValidText));
    }


    @DisplayName("Проверка дизайов карты")
    @Tag("FormForDebitCard")
    @Tag("positive")
    @ValueSource(strings = {
            "/cards/debit-cards/tinkoff-black/",
            "cards/debit-cards/tinkoff-black/foreign/eng/"
    })
    @ParameterizedTest(name = "Для url {0} отображаются правильные дизайна карт")
    void CheckChangeImage (String UrlPage) {
        Pair<String, String>[] URLs = (new URLsForTestDesign()).URLs;

        open(UrlPage);
        $("#form").scrollIntoView(true);
        checkFullAndPreview(URLs[3].getRight(), URLs[3].getLeft());

        for (Pair<String,String> PairURL: URLs){
            clickPreview (PairURL.getLeft());
            checkFullAndPreview(PairURL.getRight(), PairURL.getLeft());
        }
    }
    private void checkFullAndPreview(String full, String preview){
        $("[data-qa-type=\"uikit/individualDesign.selectedCard\"] img").shouldHave(attribute("src",full));
        $("[data-qa-type=\"uikit/individualDesign.previewSelected\"] img").shouldHave(attribute("src",preview));
    }
    private void clickPreview (String preview){
        $("[data-qa-type=\"uikit/individualDesign.preview\"] img[src=\"" + preview + "\"]").click();
    }
}

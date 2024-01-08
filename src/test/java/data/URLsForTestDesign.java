package data;

import org.apache.commons.lang3.tuple.Pair;

public class URLsForTestDesign {
    public Pair<String, String>[] URLs;
    public URLsForTestDesign(){
        URLs = new Pair[4];
        URLs[0] = Pair.of(
                "https://imgproxy.cdn-tinkoff.ru/card_design_preview_x1/aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzL2I5MTYzZGFhLWQzYWMtNGEzMy1iOWI4LTUzMDUyZDlmZmJiYy5wbmc=",
                "https://imgproxy.cdn-tinkoff.ru/card_design_desktop_x1/aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzL2I5MTYzZGFhLWQzYWMtNGEzMy1iOWI4LTUzMDUyZDlmZmJiYy5wbmc="
        );
        URLs[1] = Pair.of(
                "https://imgproxy.cdn-tinkoff.ru/card_design_preview_x1/aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzL2I1ZGEwNmJjLTEzMGMtNGJlYi04ZDMwLWE4ZGMyMTMwODNlNy5wbmc=",
                "https://imgproxy.cdn-tinkoff.ru/card_design_desktop_x1/aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzL2I1ZGEwNmJjLTEzMGMtNGJlYi04ZDMwLWE4ZGMyMTMwODNlNy5wbmc="
        );

        URLs[2] = Pair.of(
                "https://imgproxy.cdn-tinkoff.ru/card_design_preview_x1/aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzL2VkOGQwNDc2LTI0ZmUtNDk0My04NjFmLTIzYWJmNTgzNDc4MC5wbmc=",
                "https://imgproxy.cdn-tinkoff.ru/card_design_desktop_x1/aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzL2VkOGQwNDc2LTI0ZmUtNDk0My04NjFmLTIzYWJmNTgzNDc4MC5wbmc="

        );
        URLs[3] = Pair.of(
                "https://imgproxy.cdn-tinkoff.ru/card_design_preview_x1/aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzLzgzODZkNzkzLTQyZTUtNDM5Ni1hNDdlLTQ1YTE3NWQxMGE3ZS5wbmc=",
                "https://imgproxy.cdn-tinkoff.ru/card_design_desktop_x1/aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzLzgzODZkNzkzLTQyZTUtNDM5Ni1hNDdlLTQ1YTE3NWQxMGE3ZS5wbmc="
        );
    }
}

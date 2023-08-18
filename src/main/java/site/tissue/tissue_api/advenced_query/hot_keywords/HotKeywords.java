package site.tissue.tissue_api.advenced_query.hot_keywords;

public class HotKeywords {
    String Keyword;
    int value;

    public HotKeywords(String keyword, int value) {
        Keyword = keyword;
        this.value = value;
    }

    public String getKeyword() {
        return Keyword;
    }

    public void setKeyword(String keyword) {
        Keyword = keyword;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

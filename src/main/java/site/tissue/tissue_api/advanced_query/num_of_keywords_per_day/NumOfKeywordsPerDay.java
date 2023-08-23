package site.tissue.tissue_api.advanced_query.num_of_keywords_per_day;

public class NumOfKeywordsPerDay {
    String keyword;
    int value;

    public NumOfKeywordsPerDay(String keyword, int value) {
        this.keyword = keyword;
        this.value = value;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

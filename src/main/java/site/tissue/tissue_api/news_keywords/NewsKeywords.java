package site.tissue.tissue_api.news_keywords;

public class NewsKeywords {
    int id;
    String keyword;

    public NewsKeywords(int id, String keywords) {
        this.id = id;
        this.keyword = keywords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}

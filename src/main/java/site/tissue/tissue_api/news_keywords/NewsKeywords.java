package site.tissue.tissue_api.news_keywords;

public class NewsKeywords {
    int id;
    String keywords;

    public NewsKeywords(int id, String keywords) {
        this.id = id;
        this.keywords = keywords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}

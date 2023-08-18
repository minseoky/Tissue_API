package site.tissue.tissue_api.news_summaries;

public class NewsSummaries {
    int id;
    String summary;

    public NewsSummaries(int id, String summary) {
        this.id = id;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}

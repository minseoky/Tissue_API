package site.tissue.tissue_api.advanced_query.full_summaries;

public class FullSummaries {
    String img_url;
    String date;
    String press;
    String title;
    String url;
    String summary;
    String content;

    public FullSummaries(String img_url, String date, String press, String title, String url, String summary, String content) {
        this.img_url = img_url;
        this.date = date;
        this.press = press;
        this.title = title;
        this.url = url;
        this.summary = summary;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}

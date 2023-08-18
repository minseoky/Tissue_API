package site.tissue.tissue_api.news_articles;

public class NewsArticles {
    int id;
    String date;
    String title;
    String content;
    String press;
    String url;
    String img_url;

    public NewsArticles(int id, String date, String title, String content, String press, String url, String img_url) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.press = press;
        this.url = url;
        this.img_url = img_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
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
}

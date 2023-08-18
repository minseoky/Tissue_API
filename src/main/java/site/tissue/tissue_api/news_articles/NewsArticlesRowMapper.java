package site.tissue.tissue_api.news_articles;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsArticlesRowMapper implements RowMapper<NewsArticles> {
    @Override
    public NewsArticles mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt("id");
        String date = resultSet.getString("date");
        String title = resultSet.getString("title");
        String content = resultSet.getString("content");
        String press = resultSet.getString("press");
        String url = resultSet.getString("url");
        String img_url = resultSet.getString("img_url");

        return new NewsArticles(id, date, title, content, press, url, img_url);
    }
}

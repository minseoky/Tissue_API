package site.tissue.tissue_api.news_keywords;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsKeywordsRowMapper implements RowMapper<NewsKeywords> {
    @Override
    public NewsKeywords mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt("id");
        String keyword = resultSet.getString("keyword");

        return new NewsKeywords(id, keyword);
    }
}

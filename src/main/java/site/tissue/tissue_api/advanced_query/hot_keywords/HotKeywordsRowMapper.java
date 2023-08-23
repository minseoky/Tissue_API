package site.tissue.tissue_api.advanced_query.hot_keywords;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HotKeywordsRowMapper implements RowMapper<HotKeywords> {
    @Override
    public HotKeywords mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        String keyword = resultSet.getString("keyword");
        int value = resultSet.getInt("Frequency");

        return new HotKeywords(keyword, value);
    }
}

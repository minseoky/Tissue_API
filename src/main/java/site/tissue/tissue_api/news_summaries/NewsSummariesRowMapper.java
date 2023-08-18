package site.tissue.tissue_api.news_summaries;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsSummariesRowMapper implements RowMapper<NewsSummaries> {
    @Override
    public NewsSummaries mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt("id");
        String summary = resultSet.getString("summary");

        return new NewsSummaries(id, summary);
    }
}

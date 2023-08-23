package site.tissue.tissue_api.advanced_query.full_summaries;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FullSummariesRowMapper implements RowMapper<FullSummaries> {
    @Override
    public FullSummaries mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        String img_url = resultSet.getString("img_url");
        String date = resultSet.getString("date");
        String press = resultSet.getString("press");
        String title = resultSet.getString("title");
        String url = resultSet.getString("url");
        String summary = resultSet.getString("summary");
        String content = resultSet.getString("content");

        return new FullSummaries(img_url, date, press, title, url, summary, content);
    }
}

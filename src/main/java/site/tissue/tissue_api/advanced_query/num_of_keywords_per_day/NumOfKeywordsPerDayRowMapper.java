package site.tissue.tissue_api.advanced_query.num_of_keywords_per_day;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NumOfKeywordsPerDayRowMapper implements RowMapper<NumOfKeywordsPerDay> {
    @Override
    public NumOfKeywordsPerDay mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        String keyword = resultSet.getString("keyword");
        int value = resultSet.getInt("Frequency");

        return new NumOfKeywordsPerDay(keyword, value);
    }
}

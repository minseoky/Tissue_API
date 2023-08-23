package site.tissue.tissue_api.advanced_query.num_of_keywords_per_day;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.tissue.tissue_api.advanced_query.hot_keywords.HotKeywords;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class NumOfKeywordsPerDayController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NumOfKeywordsPerDayController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/num_of_keywords_per_day")
    public List<NumOfKeywordsPerDay> getNumOfKeywordsPerDay(@RequestParam String date, @RequestParam String keyword) {
        // Format date parameter to match the database format
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String formattedDate = null;
        try {
            Date parsedDate = inputDateFormat.parse(date);
            formattedDate = dbDateFormat.format(parsedDate);
        } catch (Exception e) {
            // Handle parsing error
        }

        if (formattedDate != null) {

            String startOfDay = formattedDate + " 00:00";
            String endOfDay = formattedDate + " 23:59";
            List<NumOfKeywordsPerDay> numOfKeywordsPerDayList = jdbcTemplate.query(
                    "SELECT a.KEYWORD, COUNT(*) AS Frequency\n" +
                            "FROM news_keywords a\n" +
                            "JOIN news_articles b ON a.ID = b.ID\n" +
                            "WHERE b.DATE >= ? AND b.DATE <= ? AND a.KEYWORD = ?\n" +
                            "GROUP BY a.KEYWORD\n" +
                            "ORDER BY Frequency DESC\n",
                    new Object[]{startOfDay, endOfDay, keyword},
                    new NumOfKeywordsPerDayRowMapper()
            );

            return numOfKeywordsPerDayList;
        } else {
            // Return appropriate response for parsing error
            return null;
        }
    }
}

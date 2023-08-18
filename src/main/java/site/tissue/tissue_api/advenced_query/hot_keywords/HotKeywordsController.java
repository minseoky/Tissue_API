package site.tissue.tissue_api.advenced_query.hot_keywords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class HotKeywordsController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HotKeywordsController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/hot_keywords")
    public List<HotKeywords> getHotKeywords(@RequestParam(defaultValue = "10") int topN, @RequestParam String date) {
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
            List<HotKeywords> hotKeywordsList = jdbcTemplate.query(
                    "SELECT a.KEYWORD, COUNT(*) AS Frequency\n" +
                            "FROM news_keywords a\n" +
                            "JOIN news_articles b ON a.ID = b.ID\n" +
                            "WHERE b.DATE >= ? AND b.DATE <= ?\n" +
                            "GROUP BY a.KEYWORD\n" +
                            "ORDER BY Frequency DESC\n" +
                            "LIMIT ?",
                    new Object[]{startOfDay, endOfDay, topN},
                    new HotKeywordsRowMapper()
            );

            return hotKeywordsList;
        } else {
            // Return appropriate response for parsing error
            return null;
        }
    }
}

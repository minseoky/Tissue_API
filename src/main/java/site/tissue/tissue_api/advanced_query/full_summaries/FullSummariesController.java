package site.tissue.tissue_api.advanced_query.full_summaries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class FullSummariesController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FullSummariesController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/full_summaries")
    public List<FullSummaries> getHotKeywords(@RequestParam(defaultValue = "4") int topN, @RequestParam String date, @RequestParam String keyword) {
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
            List<FullSummaries> fullSummariesList = jdbcTemplate.query(
                    "SELECT b.IMG_URL, b.DATE, b.PRESS, b.TITLE, b.URL, a.SUMMARY, b.CONTENT\n" +
                            "FROM NEWS_SUMMARIES a\n" +
                            "JOIN NEWS_ARTICLES b ON a.ID = b.ID\n" +
                            "JOIN NEWS_KEYWORDS c ON a.ID = c.ID\n" +
                            "WHERE b.DATE >= ? AND b.DATE <= ? AND c.KEYWORD = ?\n" +
                            "ORDER BY b.DATE DESC\n" +
                            "LIMIT ?",
                    new Object[]{startOfDay, endOfDay, keyword, topN},
                    new FullSummariesRowMapper()
            );

            return fullSummariesList;
        } else {
            // Return appropriate response for parsing error
            return null;
        }
    }
}

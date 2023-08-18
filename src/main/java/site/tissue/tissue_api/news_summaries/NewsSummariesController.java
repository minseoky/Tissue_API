package site.tissue.tissue_api.news_summaries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.tissue.tissue_api.news_keywords.NewsKeywords;
import site.tissue.tissue_api.news_keywords.NewsKeywordsRowMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class NewsSummariesController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NewsSummariesController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/news_summaries")
    public List<NewsSummaries> getNewsSummaries(@RequestParam String date){
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

            List<NewsSummaries> newsSummariesList = jdbcTemplate.query(
                    "SELECT * FROM news_articles a, news_summaries b WHERE a.id = b.id AND a.DATE >= ? AND a.DATE <= ?",
                    new Object[]{startOfDay, endOfDay},
                    new NewsSummariesRowMapper()
            );


            return newsSummariesList;
        } else {
            // Return appropriate response for parsing error
            return null;
        }


    }

}

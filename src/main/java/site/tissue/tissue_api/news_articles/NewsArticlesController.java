package site.tissue.tissue_api.news_articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class NewsArticlesController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NewsArticlesController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/news_articles")
    public List<NewsArticles> getNewsArticles(@RequestParam String date) {
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

            List<NewsArticles> newsArticlesList = jdbcTemplate.query(
                    "SELECT * FROM news_articles WHERE DATE >= ? AND DATE <= ?",
                    new Object[]{startOfDay, endOfDay},
                    new NewsArticlesRowMapper()
            );

            return newsArticlesList;
        } else {
            // Return appropriate response for parsing error
            return null;
        }
    }
}

package site.tissue.tissue_api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //dataSource.setUrl("jdbc:mysql://localhost:3306/tissue_db?serverTimezone=UTC&characterEncoding=UTF-8");
        dataSource.setUrl("jdbc:mysql://tissue-app-backend-database.cyzh2s69rj9f.us-east-2.rds.amazonaws.com:3306/tissue_db?serverTimezone=UTC&characterEncoding=UTF-8");
        dataSource.setUsername("tissue");
        dataSource.setPassword("tissue1234");
        //dataSource.setPassword("1234");
        return dataSource;
    }
}

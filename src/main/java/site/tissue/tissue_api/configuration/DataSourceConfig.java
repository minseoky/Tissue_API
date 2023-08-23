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
        dataSource.setUrl("jdbc:mysql://localhost:3306/tissue_db?serverTimezone=UTC&characterEncoding=UTF-8");
        //dataSource.setUrl("jdbc:mysql://192.168.0.84:3306/tissue_db?serverTimezone=UTC&characterEncoding=UTF-8");
        dataSource.setUsername("tissue");
        dataSource.setPassword("Choi304706!");
        //dataSource.setPassword("1234");
        return dataSource;
    }
}

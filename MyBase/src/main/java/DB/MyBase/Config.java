package DB.MyBase;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Value("${spring.datasource.url}")
    private String datasourseUrl;
    @Value("${spring.datasource.username}")
    private String datasourseUsername;
    @Value("${spring.datasource.password}")
    private String datasoursePassword;

    @Bean
    public DataSource dataSource(){
        HikariDataSource dataSource=new HikariDataSource();

        dataSource.setJdbcUrl(datasourseUrl);
        dataSource.setUsername(datasourseUsername);
        dataSource.setPassword(datasoursePassword);
        dataSource.setConnectionTimeout(1000);

        return dataSource;
    }

}

package financeassistant;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import financeassistant.dao.CurrencyRateDao;
import financeassistant.dao.JdbcCurrencyRateDao;

@Configuration
public class DatabaseConfig {

	@Bean
	public DataSource dataDource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("org.h2.Driver");
		source.setUrl("jdbc:h2:~/springtutorial;INIT=runscript from 'classpath:/create.sql'");
		source.setUsername("SA");
		return source;
	}

	@Bean
	public CurrencyRateDao currencyRateDao() {
		return new JdbcCurrencyRateDao();
	}
	
}

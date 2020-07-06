package financeassistant.dao;

import java.math.BigDecimal;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCurrencyRateDao implements CurrencyRateDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public BigDecimal getRate(String currency, Date rateDate) {
		return jdbcTemplate.queryForObject("select rate from currency_rates where currency=? and rate_date=?",
				new Object[] { currency, new java.sql.Date(rateDate.getTime()) }, BigDecimal.class);

	}
}

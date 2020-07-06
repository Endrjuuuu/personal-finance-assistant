package financeassistant.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import financeassistant.dto.CurrencyRate;

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

	public CurrencyRate getRateInfo(String currency, Date rateDate) {
		return jdbcTemplate.queryForObject("select * from currency_rates where currency=? and rate_date=?",
				new Object[] { currency, new java.sql.Date(rateDate.getTime()) }, new RowMapper<CurrencyRate>() {

					public CurrencyRate mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new CurrencyRate(rs.getString("CURRENCY"), rs.getDate("RATE_DATE"),
								rs.getBigDecimal("RATE"));
					}
				});
	}

	public void addRate(CurrencyRate currencyRate) {
		jdbcTemplate.update("insert into currency_rates(currency, rate_date, rate) values (?, ?, ?)",
				currencyRate.getCurrency(), new java.sql.Date(currencyRate.getRateDate().getTime()),
				currencyRate.getRate());

	}

	public void addManyRates(List<CurrencyRate> currencyRates) {
		List<Object[]> batch = new ArrayList<Object[]>();

		for (CurrencyRate currencyRate : currencyRates) {
			batch.add(new Object[] { currencyRate.getCurrency(),
					new java.sql.Date(currencyRate.getRateDate().getTime()), currencyRate.getRate() });
		}

		jdbcTemplate.batchUpdate("insert into currency_rates(currency, rate_date, rate) values (?, ?, ?)", batch);
	}
}

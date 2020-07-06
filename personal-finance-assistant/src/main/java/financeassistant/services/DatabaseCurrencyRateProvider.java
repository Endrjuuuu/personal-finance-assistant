package financeassistant.services;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import financeassistant.dao.CurrencyRateDao;

public class DatabaseCurrencyRateProvider implements CurrencyRateProvider {

	@Autowired
	private CurrencyRateDao currencyRateDao;

	public BigDecimal getRate(String currency, Date rateDate) {
		BigDecimal rate = currencyRateDao.getRate(currency, rateDate);
		System.out.println("DatabaseCurrencyRateProvider: Wczytano kursy z bazy danych, kurs = " + rate);
		return rate;
	}

}

package financeassistant.services;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import financeassistant.dao.CurrencyRateDao;
import financeassistant.dto.CurrencyRate;

public class DatabaseCurrencyRateProvider implements CurrencyRateProvider {

	@Autowired
	private CurrencyRateDao currencyRateDao;

	public BigDecimal getRate(String currency, Date rateDate) {
		BigDecimal rate = currencyRateDao.getRate(currency, rateDate);

		CurrencyRate currencyRate = currencyRateDao.getRateInfo(currency, rateDate);

		System.out.println("currencyRate: " + currencyRate);

		System.out.println("DatabaseCurrencyRateProvider: Wczytano kursy z bazy danych, kurs = " + rate);
		return rate;
	}

}

package financeassistant.services;

import java.math.BigDecimal;
import java.util.Date;

public class FileCurrencyRateProvider implements CurrencyRateProvider {

	public BigDecimal getRate(String currency, Date rateDate) {
		System.out.println("FileCurrencyRateProvider: Wczytano kursy z pliku lokalnego");
		return BigDecimal.valueOf(4.25);
	}
}

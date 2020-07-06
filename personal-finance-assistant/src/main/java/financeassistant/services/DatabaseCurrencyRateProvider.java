package financeassistant.services;

import java.math.BigDecimal;
import java.util.Date;

public class DatabaseCurrencyRateProvider implements CurrencyRateProvider {

	public BigDecimal getRate(String currency, Date rateDate) {
		System.out.println("DatabaseCurrencyRateProvider: Wczytano kursy z bazy danych");
		return BigDecimal.valueOf(4.25);
	}

}

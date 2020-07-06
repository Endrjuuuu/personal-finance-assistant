package financeassistant.dao;

import java.math.BigDecimal;
import java.util.Date;

import financeassistant.dto.CurrencyRate;

public interface CurrencyRateDao {
	BigDecimal getRate(String currency, Date rateDate);

	CurrencyRate getRateInfo(String currency, Date rateDate);

}

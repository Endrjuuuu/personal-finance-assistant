package financeassistant.dao;

import java.math.BigDecimal;
import java.util.Date;

public interface CurrencyRateDao {
	BigDecimal getRate(String currency, Date rateDate);

}

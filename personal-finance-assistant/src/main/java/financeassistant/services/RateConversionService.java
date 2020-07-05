package financeassistant.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateConversionService {

	private CurrencyRateProvider rateProvider;

	@Autowired
	public void setRateProvider(CurrencyRateProvider rateProvider) {
		this.rateProvider = rateProvider;
	}

	@Autowired(required = false)
	private Map<String, RoundPrecisionProvider> precisionProviders;

	public BigDecimal converAmount(BigDecimal amount, String currency) {
		BigDecimal rate = rateProvider.getRate(currency, new Date());
		System.out.println("RateConversionService: Obliczam kwote");
		int precision = 2;
		System.out.println("Ilosc dostawcow: " + precisionProviders.size());
		for (String providerName : precisionProviders.keySet()) {
			RoundPrecisionProvider provider = precisionProviders.get(providerName);
			System.out.println("Bean: " + providerName);
			if (provider.isSupported("PLN")) {
				precision = provider.getRoundPrecision("PLN");
			}
		}

		BigDecimal result = amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
		return result;
	}
}

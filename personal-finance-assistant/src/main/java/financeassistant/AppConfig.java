package financeassistant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import financeassistant.services.CurrencyRateProvider;
import financeassistant.services.FileCurrencyRateProvider;
import financeassistant.services.RateConversionService;

@Configuration
public class AppConfig {

	@Bean
	public CurrencyRateProvider fileCurrencyRateProvider() {
		return new FileCurrencyRateProvider();
	}

	@Bean
	public RateConversionService rateConversionService() {
		RateConversionService rateConversionService = new RateConversionService();
		rateConversionService.setRateProvider(fileCurrencyRateProvider());
		return rateConversionService;
	}

}

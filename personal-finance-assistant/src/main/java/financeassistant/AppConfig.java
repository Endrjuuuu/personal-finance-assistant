package financeassistant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import financeassistant.services.CurrencyRateProvider;
import financeassistant.services.FileCurrencyRateProvider;
import financeassistant.services.FixedPrecisionProvider;
import financeassistant.services.JpyPrecisionProvider;
import financeassistant.services.RateConversionService;
import financeassistant.services.RoundPrecisionProvider;

@Configuration
public class AppConfig {

	@Bean
	public CurrencyRateProvider fileCurrencyRateProvider() {
		return new FileCurrencyRateProvider();
	}

	@Bean
	public RateConversionService rateConversionService() {
		RateConversionService rateConversionService = new RateConversionService();
		return rateConversionService;
	}

	@Bean
	public RoundPrecisionProvider roundPrecisionProvider() {
		return new FixedPrecisionProvider();
	}

	@Bean
	public RoundPrecisionProvider roundJpyPrecisionProvider() {
		return new JpyPrecisionProvider();
	}

}

package financeassistant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;

import financeassistant.services.CurrencyRateProvider;
import financeassistant.services.DatabaseCurrencyRateProvider;
import financeassistant.services.FileCurrencyRateProvider;
import financeassistant.services.FixedPrecisionProvider;
import financeassistant.services.JpyPrecisionProvider;
import financeassistant.services.RateConversionService;
import financeassistant.services.RateUpdateService;
import financeassistant.services.RoundPrecisionProvider;

@Configuration
@Import(DatabaseConfig.class)
@PropertySource("classpath:app.properties")
public class AppConfig {

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("i18n/messages");
		return source;
	}

	@Bean
	@Profile({ "prod" })
	public CurrencyRateProvider fileCurrencyRateProvider() {
		return new FileCurrencyRateProvider();
	}

	@Bean
	@Profile("!prod")
	public CurrencyRateProvider databaseCurrencyRateProvider() {
		return new DatabaseCurrencyRateProvider();
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

	@Bean(name = "JpyRatePrecisionProvider")
	public RoundPrecisionProvider roundJpyPrecisionProvider() {
		return new JpyPrecisionProvider();
	}

	@Bean
	public RateUpdateService rateUpdateService() {
		return new RateUpdateService();
	}

}

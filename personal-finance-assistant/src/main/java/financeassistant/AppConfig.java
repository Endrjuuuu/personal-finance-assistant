package financeassistant;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "financeassistant.services" })
public class AppConfig {

	/*
	 * @Bean public CurrencyRateProvider fileCurrencyRateProvider() { return new
	 * FileCurrencyRateProvider(); }
	 * 
	 * @Bean public RateConversionService rateConversionService() {
	 * RateConversionService rateConversionService = new RateConversionService();
	 * return rateConversionService; }
	 * 
	 * @Bean public RoundPrecisionProvider roundPrecisionProvider() { return new
	 * FixedPrecisionProvider(); }
	 * 
	 * @Bean public RoundPrecisionProvider roundJpyPrecisionProvider() { return new
	 * JpyPrecisionProvider(); }
	 */

}

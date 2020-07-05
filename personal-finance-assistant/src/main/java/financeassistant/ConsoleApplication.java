package financeassistant;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import financeassistant.services.RateConversionService;

public class ConsoleApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		RateConversionService service = context.getBean(RateConversionService.class);
		service.converAmount(BigDecimal.valueOf(123.00), "EUR");

	}

}

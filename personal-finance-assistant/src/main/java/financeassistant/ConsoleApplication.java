package financeassistant;

import java.math.BigDecimal;
import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import financeassistant.services.RateConversionService;

public class ConsoleApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		RateConversionService service = context.getBean(RateConversionService.class);
		try {
			service.converAmount(BigDecimal.valueOf(123.00), "EUR");
		} catch (ParseException e) {
			System.out.println("ParseException: " + e);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

	}

}

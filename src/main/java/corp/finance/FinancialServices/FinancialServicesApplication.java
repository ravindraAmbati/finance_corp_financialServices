package corp.finance.FinancialServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
public class FinancialServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialServicesApplication.class, args);
	}

}

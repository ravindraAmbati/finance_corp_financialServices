package corp.finance.FinancialServices.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class ServiceProperties {

    private String host;
    private String port;

    @ConfigurationProperties(value = "services.collateral")
    @Bean
    public URI getCollateralServiceUrl(String endPoint) {
        try {
            return new URI(host + port + endPoint);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @ConfigurationProperties(value = "services.user")
    @Bean
    public URI getUserServiceUrl(String endPoint) {
        try {
            return new URI(host + port + endPoint);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @ConfigurationProperties(value = "services.product")
    @Bean
    public URI getProductServiceUrl(String endPoint) {
        try {
            return new URI(host + port + endPoint);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

package corp.finance.FinancialServices.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class ServicePropertiesConfiguration {

    @ConfigurationProperties(value = "services.collateral")
    @Bean
    public ServiceUrl getCollateralServiceUrl() {
        return new ServiceUrl();
    }

    public URI getCollateralServiceUrl(String endPoint) {
        ServiceUrl collateralServiceUrl = getCollateralServiceUrl();
        try {
            return new URI(collateralServiceUrl.getHost() + collateralServiceUrl.getPort() + endPoint);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @ConfigurationProperties(value = "services.user")
    @Bean
    public ServiceUrl getUserServiceUrl() {
        return new ServiceUrl();
    }

    public URI getUserServiceUrl(String endPoint) {
        ServiceUrl userServiceUrl = getUserServiceUrl();
        try {
            return new URI(userServiceUrl.getHost() + userServiceUrl.getPort() + endPoint);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @ConfigurationProperties(value = "services.product")
    @Bean
    public ServiceUrl getProductServiceUrl() {
        return new ServiceUrl();
    }

    public URI getProductServiceUrl(String endPoint) {
        ServiceUrl productServiceUrl = getProductServiceUrl();
        try {
            return new URI(productServiceUrl.getHost() + productServiceUrl.getPort() + endPoint);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

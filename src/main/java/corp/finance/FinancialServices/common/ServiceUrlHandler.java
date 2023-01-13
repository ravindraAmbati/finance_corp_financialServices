package corp.finance.FinancialServices.common;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Service
public class ServiceUrlHandler {

    public static final String HTTP = "http";
    @Value("${service.user.host}")
    private String userServiceHost;

    @Value("${service.user.port}")
    private int userServicePort;

    @Value("${service.product.host}")
    private String productServiceHost;

    @Value("${service.product.port}")
    private int productServicePort;

    @Value("${service.collateral.host}")
    private String collateralHost;

    @Value("${service.collateral.port}")
    private int collateralPort;

    public URI getUserServiceUrl(String endPoint) {
        log.info("getUserServiceUrl() endPoint: {}", endPoint);
        try {
            URI uri = new URI(HTTP, "System", userServiceHost, userServicePort, endPoint, null, null);
            log.info("getUserServiceUrl() uri: {}", uri);
            return uri;
        } catch (URISyntaxException e) {
            log.error("failed to getUserServiceUrl() ", e);
            throw new RuntimeException(e);
        }
    }

    public URI getProductServiceUrl(String endPoint) {
        log.info("getUserServiceUrl() endPoint: {}", endPoint);
        try {
            URI uri = new URI(HTTP, "System", productServiceHost, productServicePort, endPoint, null, null);
            log.info("getProductServiceUrl() uri: {}", uri);
            return uri;
        } catch (URISyntaxException e) {
            log.error("failed to getProductServiceUrl() ", e);
            throw new RuntimeException(e);
        }
    }

    public URI getCollateralServiceUrl(String endPoint) {
        log.info("getCollateralServiceUrl() endPoint: {}", endPoint);
        try {
            URI uri = new URI(HTTP, "System", collateralHost, collateralPort, endPoint, null, null);
            log.info("getCollateralServiceUrl() uri: {}", uri);
            return uri;
        } catch (URISyntaxException e) {
            log.error("failed to getCollateralServiceUrl() ", e);
            throw new RuntimeException(e);
        }
    }

}

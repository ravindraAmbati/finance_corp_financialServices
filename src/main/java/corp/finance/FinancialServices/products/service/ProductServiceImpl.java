package corp.finance.FinancialServices.products.service;

import corp.finance.FinancialServices.common.ServiceUrlHandler;
import corp.finance.FinancialServices.products.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Slf4j
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ServiceUrlHandler serviceUrlHandler;

    private static final String ALL_END_POINT = "/products/all";
    private static final String IDS_END_POINT = "/products/ids";

    @Override
    public List<Product> getAllProducts() {
        URI productServiceUrl = serviceUrlHandler.getProductServiceUrl(ALL_END_POINT);
        Product[] products = restTemplate.getForObject(productServiceUrl, Product[].class);
        if (null != products && products.length > 0) {
            return List.of(products);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Product> getProducts(List<String> productIds) {
        URI productServiceUrl = serviceUrlHandler.getProductServiceUrl(IDS_END_POINT);
        List<String> requestBody = new ArrayList<>(productIds);
        Product[] products = restTemplate.postForObject(productServiceUrl, requestBody, Product[].class);
        if (null != products && products.length > 0) {
            return List.of(products);
        }
        return Collections.emptyList();
    }

    @Override
    public Product getProduct(String productId) {
        URI productServiceUrl = serviceUrlHandler.getProductServiceUrl("/products/" + productId);
        return restTemplate.getForObject(productServiceUrl, Product.class);
    }
}

package corp.finance.FinancialServices.products.service;

import corp.finance.FinancialServices.common.ProductList;
import corp.finance.FinancialServices.common.ServiceProperties;
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
    private final ServiceProperties serviceProperties;

    private static final String ALL_END_POINT = "/all";
    private static final String IDS_END_POINT = "/ids";

    @Override
    public List<Product> getAllProducts() {
        URI productServiceUrl = serviceProperties.getProductServiceUrl(ALL_END_POINT);
        ProductList productList = restTemplate.getForObject(productServiceUrl, ProductList.class);
        List<Product> products = productList.get();
        if (null != products && !products.isEmpty()) {
            return products;
        }
        return Collections.emptyList();
    }

    @Override
    public List<Product> getProducts(List<String> productIds) {
        URI productServiceUrl = serviceProperties.getProductServiceUrl(IDS_END_POINT);
        List<String> requestBody = new ArrayList<>(productIds);
        ProductList productList = restTemplate.postForObject(productServiceUrl, requestBody, ProductList.class);
        List<Product> collaterals = productList.get();
        if (null != collaterals && !collaterals.isEmpty()) {
            return collaterals;
        }
        return Collections.emptyList();
    }

    @Override
    public Product getProduct(String productId) {
        URI productServiceUrl = serviceProperties.getProductServiceUrl("/" + productId);
        return restTemplate.getForObject(productServiceUrl, Product.class);
    }
}

package corp.finance.FinancialServices.products.service;


import corp.finance.FinancialServices.products.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getProducts(List<String> productIds);

    Product getProduct(String productId);
}

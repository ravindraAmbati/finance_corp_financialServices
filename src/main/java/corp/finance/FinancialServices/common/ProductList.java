package corp.finance.FinancialServices.common;

import corp.finance.FinancialServices.products.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductList {

    private List<Product> products = new ArrayList<>();

    public ProductList() {
        products = new ArrayList<>();
    }

    public List<Product> get() {
        if (null != products && !products.isEmpty()) {
            return products;
        }
        return Collections.emptyList();
    }
}

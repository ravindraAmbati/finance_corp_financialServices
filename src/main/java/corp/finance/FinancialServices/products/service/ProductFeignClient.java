package corp.finance.FinancialServices.products.service;

import corp.finance.FinancialServices.products.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("productManagement")
public interface ProductFeignClient {

    String ALL_END_POINT = "/products/all";
    String IDS_END_POINT = "/products/ids";

    @GetMapping(value = ALL_END_POINT)
    List<Product> getAllProducts();

    @PostMapping(value = IDS_END_POINT, consumes = "application/json")
    List<Product> getProducts(@RequestBody List<String> productIds);
}

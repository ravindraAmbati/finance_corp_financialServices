package corp.finance.FinancialServices.products.controller;

import corp.finance.FinancialServices.products.model.Product;
import corp.finance.FinancialServices.products.service.ProductFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductController {

    private final ProductFeignClient productFeignClient;

    @GetMapping("/all")
    public @ResponseBody List<Product> getAllProducts() {
        return productFeignClient.getAllProducts();
    }

    @PostMapping("/ids")
    public @ResponseBody List<Product> getProducts(@RequestBody List<String> productIds) {
        return productFeignClient.getProducts(productIds);
    }
}

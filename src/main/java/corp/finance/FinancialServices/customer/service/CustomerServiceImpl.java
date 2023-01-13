package corp.finance.FinancialServices.customer.service;

import corp.finance.FinancialServices.collateral.model.Collateral;
import corp.finance.FinancialServices.collateral.service.CollateralService;
import corp.finance.FinancialServices.customer.model.Customer;
import corp.finance.FinancialServices.products.model.Product;
import corp.finance.FinancialServices.products.service.ProductService;
import corp.finance.FinancialServices.users.model.User;
import corp.finance.FinancialServices.users.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final UserService userService;
    private final ProductService productService;
    private final CollateralService collateralService;


    @Override
    public List<Customer> getAllCustomers() {
        List<User> allUsers = userService.getAllUsers();
        List<Product> allProducts = productService.getAllProducts();
        List<Collateral> allCollaterals = collateralService.getAllCollateral();
        return buildCustomers(allUsers, allProducts, allCollaterals);
    }

    @Override
    public List<Customer> getCustomers(List<String> userIds) {
        List<String> productIds = new ArrayList<>();
        List<String> collateralIds = new ArrayList<>();
        List<User> users = userService.getUsers(userIds);
        users.forEach(
                user -> {
                    productIds.addAll(user.getProductIds());
                    collateralIds.addAll(user.getCollateralIds());
                }
        );
        List<Product> products = productService.getProducts(productIds);
        List<Collateral> collaterals = collateralService.getCollaterals(collateralIds);
        return buildCustomers(users, products, collaterals);
    }

    @Override
    public Customer getCustomer(String userId) {
        List<Product> products = new ArrayList<>();
        List<Collateral> collaterals = new ArrayList<>();
        User user = userService.getUser(userId);
        user.getProductIds().forEach(
                productId -> products.add(productService.getProduct(productId))
        );
        user.getCollateralIds().forEach(
                collateralId -> collaterals.add(collateralService.getCollateral(collateralId))
        );
        return Customer
                .builder()
                .user(user)
                .products(products)
                .collaterals(collaterals)
                .build();
    }

    private List<Customer> buildCustomers(List<User> allUsers, List<Product> allProducts, List<Collateral> allCollaterals) {
        List<Customer> customers = new ArrayList<>();
        Map<String, List<Product>> allProductsMap = allProducts
                .stream()
                .collect(Collectors.groupingBy(Product::getProductId));
        Map<String, List<Collateral>> allCollateralsMap = allCollaterals
                .stream()
                .collect(Collectors.groupingBy(Collateral::getCollateralId));
        allUsers.forEach(
                user -> {
                    AtomicReference<List<Product>> products = new AtomicReference<>();
                    AtomicReference<List<Collateral>> collaterals = new AtomicReference<>();
                    user.getProductIds().forEach(
                            productId -> products.set(allProductsMap.get(productId))
                    );
                    user.getCollateralIds().forEach(
                            collateralId -> collaterals.set(allCollateralsMap.get(collateralId))
                    );
                    Customer customer = Customer
                            .builder()
                            .user(user)
                            .products(products.get())
                            .collaterals(collaterals.get())
                            .build();
                    customers.add(customer);
                }
        );
        return customers;
    }
}

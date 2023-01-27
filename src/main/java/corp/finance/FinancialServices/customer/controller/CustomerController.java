package corp.finance.FinancialServices.customer.controller;

import corp.finance.FinancialServices.config.ServiceConfig;
import corp.finance.FinancialServices.config.model.Properties;
import corp.finance.FinancialServices.customer.model.Customer;
import corp.finance.FinancialServices.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/customers")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    private final ServiceConfig serviceConfig;

    @GetMapping("/all")
    public @ResponseBody List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/ids")
    public @ResponseBody List<Customer> getCustomers(@RequestBody List<String> userIds) {
        return customerService.getCustomers(userIds);
    }

    @GetMapping("/all/v2")
    public @ResponseBody List<Customer> getAllCustomersV2() {
        return customerService.getAllCustomersV2();
    }

    @PostMapping("/ids/v2")
    public @ResponseBody List<Customer> getCustomersV2(@RequestBody List<String> userIds) {
        return customerService.getCustomersV2(userIds);
    }

    @GetMapping("/{userId}")
    public @ResponseBody Customer getCustomer(@PathVariable("userId") String userId) {
        return customerService.getCustomer(userId);
    }

    @GetMapping("/properties")
    public @ResponseBody Properties getProperties() {
        return new Properties(serviceConfig.getMessage(), serviceConfig.getBuildVersion(), serviceConfig.getMailDetails());
    }
}

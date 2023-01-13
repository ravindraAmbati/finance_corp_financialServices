package corp.finance.FinancialServices.customer.service;

import corp.finance.FinancialServices.customer.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    List<Customer> getCustomers(List<String> userIds);

    Customer getCustomer(String userId);
}

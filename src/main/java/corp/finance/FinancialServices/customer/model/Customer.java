package corp.finance.FinancialServices.customer.model;

import corp.finance.FinancialServices.collateral.model.Collateral;
import corp.finance.FinancialServices.common.Audit;
import corp.finance.FinancialServices.products.model.Product;
import corp.finance.FinancialServices.users.model.User;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Component
public class Customer {

    private User user;
    private List<Product> products;
    private List<Collateral> collaterals;
    private Audit audit;
}

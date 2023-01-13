package corp.finance.FinancialServices.common;

import corp.finance.FinancialServices.collateral.model.Collateral;
import corp.finance.FinancialServices.products.model.Product;
import corp.finance.FinancialServices.users.model.User;
import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Component
public class Customer {

    private User user;
    private Product product;
    private Collateral collateral;
    private Audit audit;
}

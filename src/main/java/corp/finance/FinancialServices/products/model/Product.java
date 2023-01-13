package corp.finance.FinancialServices.products.model;

import corp.finance.FinancialServices.common.Audit;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Component
public class Product implements Serializable {

    private String productId;
    private String productName;
    private String productType;
    private Tenure tenure;
    private Audit audit;
}

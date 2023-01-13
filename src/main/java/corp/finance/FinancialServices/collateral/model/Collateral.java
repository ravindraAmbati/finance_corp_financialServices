package corp.finance.FinancialServices.collateral.model;

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
public class Collateral implements Serializable {

    private String collateralId;
    private String collateralName;
    private String collateralType;
    private Valuation valuation;
    private Audit audit;
}

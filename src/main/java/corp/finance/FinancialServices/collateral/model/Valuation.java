package corp.finance.FinancialServices.collateral.model;

import corp.finance.FinancialServices.common.Audit;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Component
public class Valuation {

    private String valuationId;
    private String valuationName;
    private String valuationType;
    private LocalDateTime valuatedOn;
    private LocalDateTime nextValuationDate;
    private LocalDateTime expireDate;
    private Audit audit;
}

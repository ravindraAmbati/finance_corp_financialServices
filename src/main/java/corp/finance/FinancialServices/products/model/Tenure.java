package corp.finance.FinancialServices.products.model;

import corp.finance.FinancialServices.common.Audit;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Period;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Component
public class Tenure {

    private String tenureId;
    private String tenureName;
    private Period tenurePeriod;
    private LocalDateTime tenureStartDate;
    private LocalDateTime tenureEndDate;
    private Period tenureInterval;
    private Audit audit;

}

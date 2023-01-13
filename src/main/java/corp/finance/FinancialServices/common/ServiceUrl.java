package corp.finance.FinancialServices.common;

import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Component
public class ServiceUrl {

    private String host;
    private String port;
}

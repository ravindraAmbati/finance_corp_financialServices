package corp.finance.FinancialServices.users.model;

import corp.finance.FinancialServices.common.Audit;
import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Component
public class Contact {

    private String phoneNumber;
    private String emailAddress;
    private String address;
    private Audit audit;
}

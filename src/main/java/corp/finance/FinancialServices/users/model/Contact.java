package corp.finance.FinancialServices.users.model;

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
public class Contact implements Serializable {

    private String phoneNumber;
    private String emailAddress;
    private String address;
    private Audit audit;
}

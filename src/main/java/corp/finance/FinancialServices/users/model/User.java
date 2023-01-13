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
public class User {

    private String userId;
    private String userName;
    private String userType;
    private Contact contact;
    private Audit audit;
}

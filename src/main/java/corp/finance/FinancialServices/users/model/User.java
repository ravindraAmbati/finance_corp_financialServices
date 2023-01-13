package corp.finance.FinancialServices.users.model;


import corp.finance.FinancialServices.common.Audit;
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
public class User {

    private String userId;
    private String userName;
    private String userType;
    private List<String> productIds;
    private List<String> collateralIds;
    private Contact contact;
    private Audit audit;
}

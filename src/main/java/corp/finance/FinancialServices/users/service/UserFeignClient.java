package corp.finance.FinancialServices.users.service;

import corp.finance.FinancialServices.users.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("userManagement")
public interface UserFeignClient {

    String ALL_END_POINT = "/users/all";
    String IDS_END_POINT = "/users/ids";

    @GetMapping(value = ALL_END_POINT)
    List<User> getAllUsers();

    @PostMapping(value = IDS_END_POINT, consumes = "application/json")
    List<User> getUsers(List<String> userIds);

}

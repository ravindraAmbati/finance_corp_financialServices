package corp.finance.FinancialServices.users.controller;

import corp.finance.FinancialServices.users.model.User;
import corp.finance.FinancialServices.users.service.UserFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserFeignClient userFeignClient;

    @GetMapping("/all")
    public @ResponseBody List<User> getAllUsers() {
        return userFeignClient.getAllUsers();
    }

    @PostMapping("/ids")
    public @ResponseBody List<User> getUsers(@RequestBody List<String> userIds) {
        return userFeignClient.getUsers(userIds);
    }

}

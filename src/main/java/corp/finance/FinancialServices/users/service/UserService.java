package corp.finance.FinancialServices.users.service;


import corp.finance.FinancialServices.users.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    List<User> getUsers(List<String> userIds);

    User getUser(String userId);
}

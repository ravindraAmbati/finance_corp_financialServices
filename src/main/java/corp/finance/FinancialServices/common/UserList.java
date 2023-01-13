package corp.finance.FinancialServices.common;

import corp.finance.FinancialServices.users.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserList {

    private List<User> users = new ArrayList<>();

    public UserList() {
        users = new ArrayList<>();
    }

    public List<User> get() {
        if (null != users && !users.isEmpty()) {
            return users;
        }
        return Collections.emptyList();
    }
}

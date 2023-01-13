package corp.finance.FinancialServices.users.service;

import corp.finance.FinancialServices.common.ServiceProperties;
import corp.finance.FinancialServices.common.UserList;
import corp.finance.FinancialServices.users.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ServiceProperties serviceProperties;

    private static final String ALL_END_POINT = "/all";
    private static final String IDS_END_POINT = "/ids";

    @Override
    public List<User> getAllUsers() {
        URI userServiceUrl = serviceProperties.getUserServiceUrl(ALL_END_POINT);
        UserList userList = restTemplate.getForObject(userServiceUrl, UserList.class);
        List<User> users = userList.get();
        if (null != users && !users.isEmpty()) {
            return users;
        }
        return Collections.emptyList();
    }

    @Override
    public List<User> getUsers(List<String> userIds) {
        URI userServiceUrl = serviceProperties.getUserServiceUrl(IDS_END_POINT);
        List<String> requestBody = new ArrayList<>(userIds);
        UserList userList = restTemplate.postForObject(userServiceUrl, requestBody, UserList.class);
        List<User> users = userList.get();
        if (null != users && !users.isEmpty()) {
            return users;
        }
        return Collections.emptyList();
    }

    @Override
    public User getUser(String userId) {
        URI userServiceUrl = serviceProperties.getUserServiceUrl("/" + userId);
        return restTemplate.getForObject(userServiceUrl, User.class);
    }
}

package corp.finance.FinancialServices.users.service;

import corp.finance.FinancialServices.common.ServiceUrlHandler;
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
    private final ServiceUrlHandler serviceUrlHandler;

    private static final String ALL_END_POINT = "/users/all";
    private static final String IDS_END_POINT = "/users/ids";

    @Override
    public List<User> getAllUsers() {
        URI userServiceUrl = serviceUrlHandler.getUserServiceUrl(ALL_END_POINT);
        User[] users = restTemplate.getForObject(userServiceUrl, User[].class);
        if (null != users && users.length > 0) {
            return List.of(users);
        }
        return Collections.emptyList();
    }

    @Override
    public List<User> getUsers(List<String> userIds) {
        URI userServiceUrl = serviceUrlHandler.getUserServiceUrl(IDS_END_POINT);
        List<String> requestBody = new ArrayList<>(userIds);
        User[] users = restTemplate.postForObject(userServiceUrl, requestBody, User[].class);
        if (null != users && users.length > 0) {
            return List.of(users);
        }
        return Collections.emptyList();
    }

    @Override
    public User getUser(String userId) {
        URI userServiceUrl = serviceUrlHandler.getUserServiceUrl("/users/" + userId);
        return restTemplate.getForObject(userServiceUrl, User.class);
    }
}

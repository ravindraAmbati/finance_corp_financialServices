package corp.finance.FinancialServices.collateral.service;

import corp.finance.FinancialServices.collateral.model.Collateral;
import corp.finance.FinancialServices.common.CollateralList;
import corp.finance.FinancialServices.common.ServiceProperties;
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
public class CollateralServiceImpl implements CollateralService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ServiceProperties serviceProperties;

    private static final String ALL_END_POINT = "/all";
    private static final String IDS_END_POINT = "/ids";

    @Override
    public List<Collateral> getAllCollateral() {
        URI collateralServiceUrl = serviceProperties.getCollateralServiceUrl(ALL_END_POINT);
        CollateralList collateralList = restTemplate.getForObject(collateralServiceUrl, CollateralList.class);
        List<Collateral> collaterals = collateralList.get();
        if (null != collaterals && !collaterals.isEmpty()) {
            return collaterals;
        }
        return Collections.emptyList();
    }

    @Override
    public List<Collateral> getCollateral(List<String> collateralIds) {
        URI collateralServiceUrl = serviceProperties.getCollateralServiceUrl(IDS_END_POINT);
        List<String> requestBody = new ArrayList<>(collateralIds);
        CollateralList collateralList = restTemplate.postForObject(collateralServiceUrl, requestBody, CollateralList.class);
        List<Collateral> collaterals = collateralList.get();
        if (null != collaterals && !collaterals.isEmpty()) {
            return collaterals;
        }
        return Collections.emptyList();
    }

    @Override
    public Collateral getCollateral(String collateralId) {
        URI collateralServiceUrl = serviceProperties.getCollateralServiceUrl("/" + collateralId);
        return restTemplate.getForObject(collateralServiceUrl, Collateral.class);
    }
}

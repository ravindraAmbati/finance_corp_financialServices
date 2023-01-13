package corp.finance.FinancialServices.collateral.service;

import corp.finance.FinancialServices.collateral.model.Collateral;
import corp.finance.FinancialServices.collateral.model.CollateralList;
import corp.finance.FinancialServices.common.ServicePropertiesConfiguration;
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
    private final ServicePropertiesConfiguration servicePropertiesConfiguration;

    private static final String ALL_END_POINT = "/all";
    private static final String IDS_END_POINT = "/ids";

    @Override
    public List<Collateral> getAllCollateral() {
        URI collateralServiceUrl = servicePropertiesConfiguration.getCollateralServiceUrl(ALL_END_POINT);
        CollateralList collateralList = restTemplate.getForObject(collateralServiceUrl, CollateralList.class);
        List<Collateral> collaterals = collateralList.get();
        if (null != collaterals && !collaterals.isEmpty()) {
            return collaterals;
        }
        return Collections.emptyList();
    }

    @Override
    public List<Collateral> getCollaterals(List<String> collateralIds) {
        URI collateralServiceUrl = servicePropertiesConfiguration.getCollateralServiceUrl(IDS_END_POINT);
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
        URI collateralServiceUrl = servicePropertiesConfiguration.getCollateralServiceUrl("/" + collateralId);
        return restTemplate.getForObject(collateralServiceUrl, Collateral.class);
    }
}

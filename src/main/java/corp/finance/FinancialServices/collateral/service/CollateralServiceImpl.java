package corp.finance.FinancialServices.collateral.service;

import corp.finance.FinancialServices.collateral.model.Collateral;
import corp.finance.FinancialServices.common.ServiceUrlHandler;
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
    private final ServiceUrlHandler serviceUrlHandler;

    private static final String ALL_END_POINT = "/collaterals/all";
    private static final String IDS_END_POINT = "/collaterals/ids";

    @Override
    public List<Collateral> getAllCollateral() {
        URI collateralServiceUrl = serviceUrlHandler.getCollateralServiceUrl(ALL_END_POINT);
        Collateral[] collaterals = restTemplate.getForObject(collateralServiceUrl, Collateral[].class);
        if (null != collaterals && collaterals.length > 0 ) {
            return List.of(collaterals);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Collateral> getCollaterals(List<String> collateralIds) {
        URI collateralServiceUrl = serviceUrlHandler.getCollateralServiceUrl(IDS_END_POINT);
        List<String> requestBody = new ArrayList<>(collateralIds);
        Collateral[] collaterals = restTemplate.postForObject(collateralServiceUrl, requestBody, Collateral[].class);
        if (null != collaterals && collaterals.length > 0 ) {
            return List.of(collaterals);
        }
        return Collections.emptyList();
    }

    @Override
    public Collateral getCollateral(String collateralId) {
        URI collateralServiceUrl = serviceUrlHandler.getCollateralServiceUrl("/collaterals/" + collateralId);
        return restTemplate.getForObject(collateralServiceUrl, Collateral.class);
    }
}

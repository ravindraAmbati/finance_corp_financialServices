package corp.finance.FinancialServices.collateral.service;

import corp.finance.FinancialServices.collateral.model.Collateral;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient("collateralManagement")
public interface CollateralFeignClient {

    String ALL_END_POINT = "/collaterals/all";
    String IDS_END_POINT = "/collaterals/ids";

    @GetMapping(value = ALL_END_POINT)
    List<Collateral> getAllCollaterals();

    @PostMapping(value = IDS_END_POINT, consumes = "application/json")
    List<Collateral> getCollaterals(@RequestBody List<String> collateralIds);
}

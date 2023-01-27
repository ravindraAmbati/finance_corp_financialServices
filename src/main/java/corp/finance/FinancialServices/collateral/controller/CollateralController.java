package corp.finance.FinancialServices.collateral.controller;

import corp.finance.FinancialServices.collateral.model.Collateral;
import corp.finance.FinancialServices.collateral.service.CollateralFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/collaterals")
@RestController
public class CollateralController {

    private final CollateralFeignClient collateralFeignClient;

    @GetMapping("/all")
    public @ResponseBody List<Collateral> getAllCollaterals() {
        return collateralFeignClient.getAllCollaterals();
    }

    @PostMapping("/ids")
    public @ResponseBody List<Collateral> getCollaterals(@RequestBody List<String> collateralIds) {
        return collateralFeignClient.getCollaterals(collateralIds);
    }
}

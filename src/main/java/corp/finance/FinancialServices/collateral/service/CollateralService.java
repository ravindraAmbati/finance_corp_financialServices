package corp.finance.FinancialServices.collateral.service;


import corp.finance.FinancialServices.collateral.model.Collateral;

import java.util.List;

public interface CollateralService {

    List<Collateral> getAllCollateral();

    List<Collateral> getCollateral(List<String> collateralIds);

    Collateral getCollateral(String collateralId);
}

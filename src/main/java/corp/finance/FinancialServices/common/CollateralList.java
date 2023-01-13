package corp.finance.FinancialServices.common;

import corp.finance.FinancialServices.collateral.model.Collateral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollateralList {

    private List<Collateral> collaterals = new ArrayList<>();

    public CollateralList() {
        collaterals = new ArrayList<>();
    }

    public List<Collateral> get() {
        if (null != collaterals && !collaterals.isEmpty()) {
            return collaterals;
        }
        return Collections.emptyList();
    }
}

package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class ProductQuantity {
    private final Map<String, Integer> productQuantityInfo;

    public ProductQuantity() {
        productQuantityInfo = new HashMap<>();
    }

    public void addProductQuantityInfo(String productName, int quantity) {
        productQuantityInfo.put(productName, quantity);
    }
}

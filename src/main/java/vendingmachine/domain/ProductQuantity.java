package vendingmachine.domain;

import vendingmachine.dto.ProductQuantityDTO;

import java.util.HashMap;
import java.util.Map;

public class ProductQuantity {
    private final Map<String, ProductQuantityDTO> productQuantityInfo;

    public ProductQuantity() {
        productQuantityInfo = new HashMap<>();
    }

    public void addProductQuantityInfo(String productName, ProductQuantityDTO quantity) {
        productQuantityInfo.put(productName, quantity);
    }
}

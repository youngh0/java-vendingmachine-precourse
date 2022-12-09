package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class ProductPrice {
    private final Map<String, Integer> productPriceInfo;

    public ProductPrice() {
        productPriceInfo = new HashMap<>();
    }

    public void addProductPriceInfo(String productName, int price) {
        productPriceInfo.put(productName, price);
    }
}

package vendingmachine.domain;

import vendingmachine.dto.ProductPriceDTO;

import java.util.HashMap;
import java.util.Map;

public class ProductPrice {
    private final Map<String, ProductPriceDTO> productPriceInfo;
    private int minPrice = Integer.MAX_VALUE;

    public ProductPrice() {
        productPriceInfo = new HashMap<>();
    }

    public void addProductPriceInfo(String productName, ProductPriceDTO price) {
        productPriceInfo.put(productName, price);
        minPrice = Integer.min(minPrice, price.getPrice());
    }

    public void isExistProduct(String productName) {
        if (productPriceInfo.containsKey(productName)) {
            return;
        }
        throw new IllegalArgumentException("존재하지 않는 상품명");
    }

    public boolean isBiggerThanMinPrice(int money) {
        return money >= minPrice;
    }

    public boolean buyProduct(String productName, int money) {
        return productPriceInfo.get(productName).getPrice() <= money;
    }
}

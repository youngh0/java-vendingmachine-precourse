package vendingmachine.domain;

import vendingmachine.dto.ProductPriceDTO;

import java.util.HashMap;
import java.util.Map;

public class ProductPrice {
    private final Map<String, ProductPriceDTO> productPriceInfo;

    public ProductPrice() {
        productPriceInfo = new HashMap<>();
    }

    public void addProductPriceInfo(String productName, ProductPriceDTO price) {
        productPriceInfo.put(productName, price);
    }

    public void isExistProduct(String productName) {
        if (productPriceInfo.containsKey(productName)) {
            return;
        }
        throw new IllegalArgumentException("존재하지 않는 상품명");
    }
}

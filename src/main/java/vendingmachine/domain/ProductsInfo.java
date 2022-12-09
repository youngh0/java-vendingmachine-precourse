package vendingmachine.domain;

import vendingmachine.dto.ProductPriceDTO;
import vendingmachine.dto.ProductQuantityDTO;

public class ProductsInfo {
    private final ProductPrice productPrice;
    private final ProductQuantity productQuantity;

    public ProductsInfo(ProductPrice productPrice, ProductQuantity productQuantity) {
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public void addProduct(String productInfoInput) {
        for (String OneProductInfo : productInfoInput.split(";")) {
            validateOneProductInfo(OneProductInfo);
        }
    }

    private void validateOneProductInfo(String productInfoInput) {
        validateShape(productInfoInput);
        String[] productInfo = productInfoInput.split(",");
        String price = productInfo[1];
        String quantity = productInfo[2];
        validatePrice(price);
        validateQuantity(quantity.substring(0, quantity.length() - 1));
    }

    private void validateShape(String productInfoInput) {
        if (productInfoInput.startsWith("[")
                && productInfoInput.endsWith("]")
                && productInfoInput.split(",").length == 3) {
            return;
        }
        throw new IllegalArgumentException("잘못된 상품 형태 입력");
    }

    private ProductPriceDTO validatePrice(String price) {
        return new ProductPriceDTO(price);
    }

    private ProductQuantityDTO validateQuantity(String quantity) {
        return new ProductQuantityDTO(quantity);
    }
}

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

    public void initProductInfo(String productInfoInput) {
        for (String oneProductInfo : productInfoInput.split(";")) {
            validateOneProductInfo(oneProductInfo);
            addProductInfo(oneProductInfo);
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

    private void validatePrice(String price) {
        new ProductPriceDTO(price);
    }

    private void validateQuantity(String quantity) {
        new ProductQuantityDTO(quantity);
    }

    private void addProductInfo(String oneProductInfo) {
        String[] productInfo = oneProductInfo.split(",");
        String productName = productInfo[0].substring(0, productInfo[0].length() - 1);
        String price = productInfo[1];
        String quantity = productInfo[2].substring(0, productInfo[2].length() - 1);
        productPrice.addProductPriceInfo(productName, new ProductPriceDTO(price));
        productQuantity.addProductQuantityInfo(productName, new ProductQuantityDTO(quantity));
    }
}

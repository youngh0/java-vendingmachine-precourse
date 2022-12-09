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

    public boolean isPossibleBuyAnything(int money) {
        return productPrice.isBiggerThanMinPrice(money) && productQuantity.checkRemainQuantity();
    }

    public void isExistProduct(String productName) {
        productPrice.isExistProduct(productName);
    }

    public void buyProduct(String productName, PaymentMoney money) {
        if(productPrice.buyProduct(productName, money.getMoney()) && productQuantity.buyProduct(productName)){
            productPrice.minusRestMoney(money, productName);
            return;
        }
        throw new IllegalArgumentException("구매 불가");
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
        String productName = productInfo[0].substring(1);
        String price = productInfo[1];
        String quantity = productInfo[2].substring(0, productInfo[2].length() - 1);
        productPrice.addProductPriceInfo(productName, new ProductPriceDTO(price));
        productQuantity.addProductQuantityInfo(productName, new ProductQuantityDTO(quantity));
    }
}

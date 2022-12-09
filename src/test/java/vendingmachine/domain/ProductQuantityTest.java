package vendingmachine.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductQuantityTest {
    ProductsInfo productsInfo;
    ProductPrice productPrice;
    ProductQuantity productQuantity;
    @BeforeEach
    void init() {
        productPrice = new ProductPrice();
        productQuantity = new ProductQuantity();
        productsInfo = new ProductsInfo(productPrice, productQuantity);

    }

    @Test
    void buyProductTest() {
        productsInfo.initProductInfo("[콜라,1000,4];[사이다,1400,1]");
        productQuantity.buyProduct("콜라", 2);
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> productQuantity.buyProduct("콜라", 3));
    }
}
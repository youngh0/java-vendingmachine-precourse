package vendingmachine.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductsInfoTest {
    ProductsInfo productsInfo;
    @BeforeEach
    void init() {
        productsInfo = new ProductsInfo(new ProductPrice(), new ProductQuantity());
    }

    @ParameterizedTest
    @ValueSource(strings = {"[상품명,10,1]", "[상품명,100,0]", "[상품명,10,1}", "{상품명,10,1]", "[상품명,10,1.1]", "",
            "[상품명,10,1];[상품명,1000,1]"})
    void addProductTest(String productInfo) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> productsInfo.initProductInfo(productInfo));
    }

    @Test
    void isExistTest() {
        productsInfo.initProductInfo("[콜라,1000,2];[사이다,1400,1]");
        productsInfo.show();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> productsInfo.isExistProduct("환타"));
    }
}
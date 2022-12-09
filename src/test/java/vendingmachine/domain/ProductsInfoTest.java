package vendingmachine.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductsInfoTest {

    @ParameterizedTest
    @ValueSource(strings = {"[상품명,10,1]", "[상품명,100,0]", "[상품명,10,1}", "{상품명,10,1]", "[상품명,10,1.1]", "",
            "[상품명,10,1];[상품명,1000,1]"})
    void addProductTest(String productInfo) {
        ProductsInfo productsInfo = new ProductsInfo(new ProductPrice(), new ProductQuantity());
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> productsInfo.initProductInfo(productInfo));
    }
}
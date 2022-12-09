package vendingmachine.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductsInfoTest {
    ProductsInfo productsInfo;
    ProductQuantity productQuantity;
    @BeforeEach
    void init() {
        productQuantity = new ProductQuantity();
        productsInfo = new ProductsInfo(new ProductPrice(), productQuantity);
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
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> productsInfo.isExistProduct("환타"));
    }

    @Test
    void isPossibleBuyAnythingTest() {
        productsInfo.initProductInfo("[콜라,1000,2];[사이다,1400,1]");
        org.assertj.core.api.Assertions.assertThat(productsInfo.isPossibleBuyAnything(1000)).isEqualTo(true);
    }

    @Test
    void isPossibleBuyAnythingTestByLackMoney() {
        productsInfo.initProductInfo("[콜라,1000,2];[사이다,1400,1]");
        org.assertj.core.api.Assertions.assertThat(productsInfo.isPossibleBuyAnything(990)).isEqualTo(false);
    }

    @Test
    void isPossibleBuyAnythingTestByNoQuantity() {
        productsInfo.initProductInfo("[콜라,1000,2];[사이다,1400,1]");
        productQuantity.buyProduct("콜라");
        productQuantity.buyProduct("사이다");
        org.assertj.core.api.Assertions.assertThat(productsInfo.isPossibleBuyAnything(990)).isEqualTo(false);
    }

    @Test
    void buyProductTestLackMoney() {
        productsInfo.initProductInfo("[콜라,1000,3];[사이다,1400,1]");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> productsInfo.buyProduct("콜라", new PaymentMoney("990")));
    }

    @Test
    void buyProductTestLackQuantity() {
        productsInfo.initProductInfo("[콜라,1000,3];[사이다,1400,1]");
        productsInfo.buyProduct("사이다", new PaymentMoney("1400"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> productsInfo.buyProduct("사이다", new PaymentMoney("1400") ));
    }

    @Test
    void buyProductTest() {
        PaymentMoney money = new PaymentMoney("1500");
        productsInfo.initProductInfo("[콜라,1000,3];[사이다,1400,1]");
        productsInfo.buyProduct("콜라",  money);
        org.assertj.core.api.Assertions.assertThat(money.getMoney()).isEqualTo(500);
    }
}
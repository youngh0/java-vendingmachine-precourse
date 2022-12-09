package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductPriceTest {
    ProductsInfo productsInfo;
    ProductPrice productPrice;
    @BeforeEach
    void init() {
        productPrice = new ProductPrice();
        productsInfo = new ProductsInfo(productPrice, new ProductQuantity());

    }

    @Test
    @DisplayName("현재 금액이 최저가격 상품보다 많거나 같은 경우")
    void isBiggerThanMinPriceTest() {
        productsInfo.initProductInfo("[콜라,1000,2];[사이다,1400,1]");
        Assertions.assertThat(productPrice.isBiggerThanMinPrice(1000)).isEqualTo(true);
    }

    @Test
    @DisplayName("현재 금액이 최저가격 상품보다 적은 경우")
    void isBiggerThanMinPriceFalseTest() {
        productsInfo.initProductInfo("[콜라,1000,2];[사이다,1400,1]");
        Assertions.assertThat(productPrice.isBiggerThanMinPrice(990)).isEqualTo(false);
    }
}
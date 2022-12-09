package vendingmachine.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductPriceDTOTest {
    @ParameterizedTest
    @ValueSource(strings = {"0100", "99", "109", "100 "})
    void productPriceDTOValidationTest(String price) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ProductPriceDTO(price));
    }
}
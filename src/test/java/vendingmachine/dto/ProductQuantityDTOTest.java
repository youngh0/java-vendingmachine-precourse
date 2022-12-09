package vendingmachine.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductQuantityDTOTest {
    @ParameterizedTest
    @ValueSource(strings = {"01", "0", ""})
    void quantityValidationTest(String quantity) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ProductQuantityDTO(quantity));
    }
}
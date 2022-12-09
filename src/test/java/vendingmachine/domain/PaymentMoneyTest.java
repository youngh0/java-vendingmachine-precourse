package vendingmachine.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PaymentMoneyTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "19"})
    void paymentMoneyValidationTest(String money) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new PaymentMoney(money));
    }
}
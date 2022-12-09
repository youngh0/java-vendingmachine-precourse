package vendingmachine.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VendingMachineMoneyTest {
    @ParameterizedTest
    @ValueSource(strings = {"0400", "401", "4,000", "400 "})
    void validateVendingMachineTest(String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new VendingMachineMoney(input));
    }
}
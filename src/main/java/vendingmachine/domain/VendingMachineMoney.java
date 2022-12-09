package vendingmachine.domain;

public class VendingMachineMoney {
    private final int money;

    public VendingMachineMoney(String input) {
        validate(input);
        money = Integer.parseInt(input);
    }

    private void validate(String input) {
        isOnlyNumber(input);
        isTenUnit(input);
    }

    private void isOnlyNumber(String input) {
        String numberRegex = "^[1-9][0-9]*$";
        if (input.matches(numberRegex)) {
            return;
        }
        throw new IllegalArgumentException("숫자만");
    }

    private void isTenUnit(String input) {
        if (input.endsWith("0")) {
            return;
        }
        throw new IllegalArgumentException("10단위만");
    }
}

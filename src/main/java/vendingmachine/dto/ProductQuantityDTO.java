package vendingmachine.dto;

public class ProductQuantityDTO {
    private int quantity;

    public ProductQuantityDTO(String quantity) {
        validate(quantity);
        this.quantity = Integer.parseInt(quantity);
    }

    private void validate(String quantity) {
        isNumber(quantity);
        isOverZero(quantity);
    }

    private void isNumber(String quantity) {
        String numberRegex = "^[1-9][0-9]*$";
        if (quantity.matches(numberRegex)) {
            return;
        }
        throw new IllegalArgumentException("수량은 숫자만");
    }

    private void isOverZero(String quantity) {
        if (Integer.parseInt(quantity) > 0) {
            return;
        }
        throw new IllegalArgumentException("수량은 1이상");
    }
}

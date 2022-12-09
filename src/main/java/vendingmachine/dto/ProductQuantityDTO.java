package vendingmachine.dto;

public class ProductQuantityDTO {
    private int quantity;

    public ProductQuantityDTO(String quantity) {
        validate(quantity);
        this.quantity = Integer.parseInt(quantity);
    }

    public boolean buyProduct() {
        if (quantity < 1) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
        quantity -= 1;
        return true;
    }

    public int getQuantity() {
        return quantity;
    }

    private void validate(String quantity) {
        isNumber(quantity);
        isOverZero(quantity);
    }

    private void isNumber(String quantity) {
        try {
            Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수량은 숫자만");
        }
    }

    private void isOverZero(String quantity) {
        if (Integer.parseInt(quantity) > 0) {
            return;
        }
        throw new IllegalArgumentException("수량은 1이상");
    }
}

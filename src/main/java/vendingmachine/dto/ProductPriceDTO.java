package vendingmachine.dto;

public class ProductPriceDTO {
    private final int price;

    public ProductPriceDTO(String price) {
        validate(price);
        this.price = Integer.parseInt(price);
    }

    public int getPrice() {
        return price;
    }

    private void validate(String price) {
        isNumber(price);
        validatePriceShape(price);
    }

    private void isNumber(String price) {
        String numberRegex = "^[1-9][0-9]*$";
        if (price.matches(numberRegex)) {
            return;
        }
        throw new IllegalArgumentException("가격은 숫자만");
    }

    private void validatePriceShape(String price) {
        if (Integer.parseInt(price) >= 100 && price.endsWith("0")) {
            return;
        }
        throw new IllegalArgumentException("가격은 100원 이상 10원 단위의 숫자만");
    }


}

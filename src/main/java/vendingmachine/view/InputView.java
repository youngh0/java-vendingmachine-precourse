package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.*;

public class InputView {
    private final String errorMessage = "[ERROR] ";
    public VendingMachineMoney readVendingMachineMoney() {
        while (true) {
            try {
                System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
                return new VendingMachineMoney(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage + e.getMessage());
            }
        }

    }

    public ProductsInfo readProducts() {
        while (true) {
            try {
                System.out.println("상품명과 가격, 수량을 입력해 주세요.");
                String products = Console.readLine();
                ProductsInfo productsInfo = new ProductsInfo(new ProductPrice(), new ProductQuantity());
                productsInfo.initProductInfo(products);
                return productsInfo;
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage + e.getMessage());
            }
        }
    }

    public PaymentMoney readMoney() {
        while (true) {
            try {
                System.out.println("투입 금액을 입력해 주세요.");
                return new PaymentMoney(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage + e.getMessage());
            }
        }

    }

    public String readProductName() {
        while (true) {
            try {
                System.out.println("구매할 상품명을 입력해 주세요.");
                return Console.readLine();
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage + e.getMessage());
            }
        }
    }
}

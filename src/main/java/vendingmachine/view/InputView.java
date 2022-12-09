package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.*;

public class InputView {
    public VendingMachineMoney readVendingMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return new VendingMachineMoney(Console.readLine());
    }

    public ProductsInfo readProducts() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String products = Console.readLine();
        ProductsInfo productsInfo = new ProductsInfo(new ProductPrice(), new ProductQuantity());
        productsInfo.initProductInfo(products);
        return productsInfo;
    }

    public PaymentMoney readMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
        return new PaymentMoney(Console.readLine());
    }

    public String readProductName() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine();
    }
}

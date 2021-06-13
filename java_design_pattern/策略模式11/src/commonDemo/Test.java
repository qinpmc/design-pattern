package commonDemo;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        QuoteManager qm = new QuoteManager();
        BigDecimal originalPrice = new BigDecimal(1000);

        String customer1 = "老客户";
        BigDecimal price1 = qm.quote(originalPrice,customer1);
        System.out.println(price1);

        System.out.println("*******************************");

        String customer2 = "VIP客户";
        BigDecimal price2 = qm.quote(originalPrice,customer2);
        System.out.println(price2);
    }
}

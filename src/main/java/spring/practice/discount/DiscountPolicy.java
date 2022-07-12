package spring.practice.discount;

import org.springframework.stereotype.Component;
import spring.practice.order.Order;

@Component
public class DiscountPolicy {
    private String name;
    private String pName;
    private int price;
    private int pNumber;
    private int discountPrice;
    private int DisPercent = 20;

    public int discount(int price, int pNumber) {
        int total = price*pNumber;
        if(total>40000) {
            return (DisPercent*(total)/100);
        }
        else return 0;
    }

}

package spring.practice.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.practice.AppConfig;
import spring.practice.member.Member;
import spring.practice.order.Order;

public class DiscountPolicyTest {

    DiscountPolicy discountPolicy;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        discountPolicy = appConfig.discountPolicy();
    }

    @Test
    void discountGood() {
        int discount = discountPolicy.discount(30000, 2);
        Member member = new Member("judy", 23, 1L);

        Assertions.assertThat(discount).isEqualTo(12000);
    }

}

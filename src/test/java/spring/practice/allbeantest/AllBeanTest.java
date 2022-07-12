package spring.practice.allbeantest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.practice.AutoAppConfig;
import spring.practice.discount.DiscountPolicy;
import spring.practice.member.Member;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac =
        new AnnotationConfigApplicationContext(DiscountService.class, AutoAppConfig.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        int discount = discountService.discount(10000, 7, "discountPolicy");

        Assertions.assertThat(discount).isEqualTo(14000);
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
        }

        public int discount( int price, int number, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(price, number);
        }
    }
}

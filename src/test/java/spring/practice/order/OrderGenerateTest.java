package spring.practice.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.practice.AppConfig;
import spring.practice.member.Member;
import spring.practice.member.MemberManage;

public class OrderGenerateTest {

    OrderGenerate orderGenerate;
    MemberManage memberManage;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        orderGenerate = appConfig.orderGenerate();
        memberManage = appConfig.memberManage();
    }

    @Test
    void OrderTest() {
        String name = "judy";
        Member member = new Member(name, 23, 1L);
        memberManage.join(member);

        Order order = orderGenerate.createOrder(name,"shirt", 10000, 5);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(10000);
    }
}

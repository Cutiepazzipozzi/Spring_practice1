package spring.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.practice.discount.DiscountPolicy;
import spring.practice.member.MemberManage;
import spring.practice.member.MemberManageImpl;
import spring.practice.member.MemberRepository;
import spring.practice.member.MemberRepositoryImpl;
import spring.practice.order.OrderGenerate;
import spring.practice.order.OrderGenerateImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberManage memberManage() {
        return new MemberManageImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepositoryImpl();
    }

    @Bean
    public OrderGenerate orderGenerate() {
        return new OrderGenerateImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new DiscountPolicy();
    }

}

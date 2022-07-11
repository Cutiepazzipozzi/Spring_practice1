package spring.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.practice.member.MemberRepository;
import spring.practice.member.MemberRepositoryImpl;

@Configuration
public class SameBeanConfig {

    @Bean
    public MemberRepository memberRepository1() {
        return new MemberRepositoryImpl();
    }

    @Bean
    public MemberRepository memberRepository2() {
        return new MemberRepositoryImpl();
    }
}

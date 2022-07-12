package spring.practice.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.practice.AppConfig;
import spring.practice.SameBeanConfig;
import spring.practice.member.MemberRepository;
import spring.practice.member.MemberRepositoryImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;

//중복 빈 처리를 보는 것이기 때문에 bean에 같은 타입 2개만 추가돼야함

public class DuplicationTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    void findBeanDuplicate() {
        //원래 ac.getBean을 바로 사용하나 예외의 경우이므로 예외처리를 따로 해줘야함
        assertThrows(NoUniqueBeanDefinitionException.class, () ->
                ac.getBean(MemberRepository.class));
    }

    @Test
    void findBeanByName() {
        MemberRepository memberRepository
                = ac.getBean("memberRepository1", MemberRepository.class);
        Assertions.assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

}

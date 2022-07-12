package spring.practice.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.practice.AppConfig;
import spring.practice.member.MemberManage;
import spring.practice.member.MemberManageImpl;

public class ApplicationContextTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
        }
    }

    @Test
    void findBeanName() {
        MemberManage memberManage
                = ac.getBean("memberManage", MemberManage.class);
        Assertions.assertThat(memberManage).isInstanceOf(MemberManageImpl.class);
    }

    @Test
    void findOnlyType() {
        MemberManage memberManage
                 = ac.getBean(MemberManage.class);
        Assertions.assertThat(memberManage).isInstanceOf(MemberManageImpl.class);
    }

    @Test
    void findSpecific() {
        MemberManage memberManage
                 = ac.getBean("memberManage", MemberManageImpl.class);
        Assertions.assertThat(memberManage).isInstanceOf(MemberManageImpl.class);
    }
}

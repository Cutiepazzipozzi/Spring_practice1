package spring.practice.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.practice.AppConfig;
import spring.practice.member.MemberManageImpl;
import spring.practice.order.OrderGenerateImpl;

public class ConfigurationTest {
    ApplicationContext ac
             = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberManageImpl memberManage = ac.getBean("memberManage", MemberManageImpl.class);
    OrderGenerateImpl orderGenerate = ac.getBean("orderGenerate", OrderGenerateImpl.class);


}

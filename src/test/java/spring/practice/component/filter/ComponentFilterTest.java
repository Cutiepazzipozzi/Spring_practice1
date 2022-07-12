package spring.practice.component.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import spring.practice.AutoAppConfig;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Configuration
@ComponentScan(
        includeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION ,classes = MyIncludeComponent.class),
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION ,classes = MyExcludeComponent.class)
)
public class ComponentFilterTest {

    @Test
    void ComponentTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        Assertions.assertThat(beanA).isInstanceOf(BeanA.class);

        assertThrows(NoSuchBeanDefinitionException.class, () ->
                ac.getBean("beanB", BeanB.class));
    }
}

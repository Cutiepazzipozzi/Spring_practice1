package spring.practice.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletoneBeanTest {
    @Test
    void 싱글톤테스트() {
        AnnotationConfigApplicationContext ac
            = new AnnotationConfigApplicationContext(SingletoneBean.class);
        SingletoneBean singletoneBean1 = ac.getBean(SingletoneBean.class);
        SingletoneBean singletoneBean2 = ac.getBean(SingletoneBean.class);
        Assertions.assertThat(singletoneBean1).isSameAs(singletoneBean2);

        ac.close();
    }

    @Scope("singletone")
    static class SingletoneBean {

        @PostConstruct
        public void init() {
            System.out.println("SingletoneBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletoneBean.destroy");
        }
    }
}

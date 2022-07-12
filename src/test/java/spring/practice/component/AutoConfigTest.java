package spring.practice.component;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.practice.AutoAppConfig;
import spring.practice.member.MemberManage;
import spring.practice.member.MemberManageImpl;

public class AutoConfigTest {

    @Test
    void test() {
        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberManage memberManage = ac.getBean(MemberManage.class);
        Assertions.assertThat(memberManage).isInstanceOf(MemberManage.class);
    }

}

//근데 얘는 왜 자꾸 오류가 날까
//bean 등록이 두개라는데 나는 ManageImpl밖에 안한 거 같은뎅뎅
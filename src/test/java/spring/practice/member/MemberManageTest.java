package spring.practice.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.practice.AppConfig;

public class MemberManageTest {

    MemberManage memberManage;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberManage = appConfig.memberManage();
    }

    @Test
    void join() {
        Member member = new Member("judy", 23, 1L);
        memberManage.join(member);

        Member findMember = memberManage.findMember("judy");
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}

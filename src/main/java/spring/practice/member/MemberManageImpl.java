package spring.practice.member;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class MemberManageImpl implements MemberManage{

    MemberRepository memberRepository = new MemberRepositoryImpl();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(String name) {
        return memberRepository.findByName(name);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

package spring.practice.member;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberManageImpl implements MemberManage{

    private final MemberRepository memberRepository;

    public MemberManageImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(String name) {
        return memberRepository.findByName(name);
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

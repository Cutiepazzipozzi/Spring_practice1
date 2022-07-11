package spring.practice.member;

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

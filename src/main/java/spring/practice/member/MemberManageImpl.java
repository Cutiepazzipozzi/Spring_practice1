package spring.practice.member;

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

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

package spring.practice.member;

public interface MemberManage {
   void join(Member member);
   Member findMember(String name);
}

package spring.practice.member;

import java.util.List;

public interface MemberManage {
   void join(Member member);
   Member findMember(String name);
   List<Member> findMembers();
}

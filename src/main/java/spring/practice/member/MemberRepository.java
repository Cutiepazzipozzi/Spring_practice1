package spring.practice.member;

import java.util.List;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long id);
    Member findByName(String name);
    List<Member> findAll();
}

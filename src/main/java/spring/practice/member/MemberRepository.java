package spring.practice.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long id);
    Member findByName(String name);
}

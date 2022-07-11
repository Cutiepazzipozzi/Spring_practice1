package spring.practice.member;

import java.util.HashMap;
import java.util.Map;

public class MemberRepositoryImpl implements MemberRepository {

    private static Map<String, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getName(), member);
}

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }

    @Override
    public Member findByName(String name) {
        return store.get(name);
    }

}

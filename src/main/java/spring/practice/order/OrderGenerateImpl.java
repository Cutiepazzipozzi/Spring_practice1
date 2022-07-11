package spring.practice.order;

import spring.practice.discount.DiscountPolicy;
import spring.practice.member.Member;
import spring.practice.member.MemberRepository;

public class OrderGenerateImpl implements OrderGenerate {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderGenerateImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(String name, String pName, int price, int pNumber) {
        Member member = memberRepository.findByName(name);
        int discountP = discountPolicy.discount(price, pNumber);

        return new Order(name, pName, price, pNumber, discountP);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

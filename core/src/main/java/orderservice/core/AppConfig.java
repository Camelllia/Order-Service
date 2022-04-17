package orderservice.core;

import orderservice.core.discount.DiscountPolicy;
import orderservice.core.discount.FixDiscountPolicy;
import orderservice.core.discount.RateDiscountPolicy;
import orderservice.core.member.MemberRepository;
import orderservice.core.member.MemberService;
import orderservice.core.member.MemberServiceImpl;
import orderservice.core.member.MemoryMemberRepository;
import orderservice.core.order.OrderSerivceImpl;
import orderservice.core.order.OrderService;

public class AppConfig {

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderSerivceImpl(memberRepository(),discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}

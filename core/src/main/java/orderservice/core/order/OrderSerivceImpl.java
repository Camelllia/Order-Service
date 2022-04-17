package orderservice.core.order;

import orderservice.core.discount.DiscountPolicy;
import orderservice.core.discount.FixDiscountPolicy;
import orderservice.core.discount.RateDiscountPolicy;
import orderservice.core.member.Member;
import orderservice.core.member.MemberRepository;
import orderservice.core.member.MemoryMemberRepository;

public class OrderSerivceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderSerivceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

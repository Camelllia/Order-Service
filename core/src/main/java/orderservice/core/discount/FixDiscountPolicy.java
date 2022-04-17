package orderservice.core.discount;

import orderservice.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 할인 금액

    @Override
    public int discount(Member member, int price) {
        switch (member.getGrade()) {
            case VIP:
                return discountFixAmount;
            default:
                return 0;
        }
    }
}

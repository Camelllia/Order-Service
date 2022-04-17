package orderservice.core.discount;

import orderservice.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        switch (member.getGrade()) {
            case VIP:
                return (price * 10) / 100;
            default:
                return 0;
        }
    }
}

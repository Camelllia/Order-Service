package orderservice.core.discount;

import orderservice.core.member.Grade;
import orderservice.core.member.Member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인")
    void vip_discount() {

        Member member = new Member(1L, "VIPTester", Grade.VIP);

        int ResultPrice = discountPolicy.discount(member, 10000);

        assertThat(ResultPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("일반인은 할인 X")
    void Default_discount() {

        Member member = new Member(2L, "DefaultTester", Grade.BASIC);

        int ResultPrice = discountPolicy.discount(member, 10000);

        assertThat(ResultPrice).isEqualTo(0);
    }
}
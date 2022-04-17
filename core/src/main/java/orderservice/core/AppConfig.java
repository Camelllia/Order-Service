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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderSerivceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}

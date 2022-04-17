package orderservice.core.order;

import orderservice.core.AppConfig;
import orderservice.core.discount.DiscountPolicy;
import orderservice.core.discount.FixDiscountPolicy;
import orderservice.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();

        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {

        Long memberId =  1L;
        Member member = new Member(memberId, "memberTest", Grade.VIP);
        
        //가입해주고
        memberService.join(member);
        //주문 객체 생성
        Order order = orderService.createOrder(memberId, "itemTest", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        Assertions.assertThat(order.calculatePrice()).isEqualTo(9000);
    }
}

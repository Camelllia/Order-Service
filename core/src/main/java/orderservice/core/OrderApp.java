package orderservice.core;

import orderservice.core.member.Grade;
import orderservice.core.member.Member;
import orderservice.core.member.MemberService;
import orderservice.core.member.MemberServiceImpl;
import orderservice.core.order.Order;
import orderservice.core.order.OrderSerivceImpl;
import orderservice.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

       /* AppConfig appConfig = new AppConfig();

        //DI 준수
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        // 회원 정보 넣고
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // 주문
        Order order =orderService.createOrder(memberId, "itemA", 10000);

        // 결과
        System.out.println("order = " + order.toString());
        System.out.println("최종 결제 금액 = " + order.calculatePrice());
    }
}

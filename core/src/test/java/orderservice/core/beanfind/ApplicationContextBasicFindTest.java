package orderservice.core.beanfind;

import orderservice.core.AppConfig;
import orderservice.core.member.MemberService;
import orderservice.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void FindBeanByName() {

        MemberService memberService = ac.getBean("memberService", MemberService.class);

        /*System.out.println("memberService = " + memberService);
        System.out.println("memberService = " + memberService.getClass());*/

        // memberService가 MemberServiceImpl의 인스턴스인지 확인
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void FindBeanByType() {

        MemberService memberService = ac.getBean(MemberService.class);

        /*System.out.println("memberService = " + memberService);
        System.out.println("memberService = " + memberService.getClass());*/

        // memberService가 MemberServiceImpl의 인스턴스인지 확인
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void FindBeanByName2() {

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);

        // memberServiceImpl이 MemberServiceImpl의 인스턴스인지 확인
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void FindBeanByNameNull() {
        //60 Line의 람다를 실행했을 때 59 Line의 예외가 터져야 함
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("None", MemberService.class));
    }
}

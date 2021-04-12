package com.bit.springpractice.singleton;
import com.bit.AppConfig;
import com.bit.member.MemberRepository;
import com.bit.member.MemberService;
import com.bit.member.MemberServiceImpl;
import com.bit.order.Order;
import com.bit.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Member;

import static org.assertj.core.api.Assertions.*;
public class ConfigurationSingletonTest {
    @Test


    void configurationTest(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderServices = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository",MemberRepository.class);

        //모두 같은 인스턴스를 참조하는지 출력해보기
        System.out.println("memberService -> memberRepository="+ memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository="+orderServices.getMemberRepository());
        System.out.println("memberRepository-> memberRepository="+memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderServices.getMemberRepository()).isSameAs(memberRepository);
    }
    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = "+bean.getClass());
    }
}

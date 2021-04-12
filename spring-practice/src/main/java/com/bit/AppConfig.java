package com.bit;

import com.bit.discount.DiscountPolicy;
import com.bit.discount.FixDiscountPolicy;
import com.bit.member.MemberRepository;
import com.bit.member.MemberService;
import com.bit.member.MemberServiceImpl;
import com.bit.member.MemoryMemberRepository;
import com.bit.order.OrderService;
import com.bit.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        //1번
        System.out.println("1.call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        //1번
        System.out.println("2.call AppConfig.memberService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }
    @Bean
    public MemberRepository memberRepository(){
        //3번
        System.out.println("2 or 3? call AppConfig.memberService");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }


}

package com.bit;

import com.bit.discount.DiscountPolicy;
import com.bit.discount.FixDiscountPolicy;
import com.bit.member.MemberRepository;
import com.bit.member.MemberService;
import com.bit.member.MemberServiceImpl;
import com.bit.member.MemoryMemberRepository;
import com.bit.order.OrderService;
import com.bit.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }


}

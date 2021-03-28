package com.bit.springpractice.order;

import com.bit.AppConfig;
import com.bit.member.Grade;
import com.bit.member.Member;
import com.bit.member.MemberService;
import com.bit.member.MemberServiceImpl;
import com.bit.order.Order;
import com.bit.order.OrderService;
import com.bit.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder(){
        long memberId=1l;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}

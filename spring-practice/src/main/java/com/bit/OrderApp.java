package com.bit;

import com.bit.member.Grade;
import com.bit.member.Member;
import com.bit.member.MemberService;
import com.bit.member.MemberServiceImpl;
import com.bit.order.Order;
import com.bit.order.OrderService;
import com.bit.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args){
        AppConfig appConfig=new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        long memberId=1l;
        Member member = new Member(memberId,"MemberA", Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId,"itemA",10000);
        System.out.println("order + " +order);
    }

}

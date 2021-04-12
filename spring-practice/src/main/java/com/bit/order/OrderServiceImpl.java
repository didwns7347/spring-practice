package com.bit.order;

import com.bit.discount.DiscountPolicy;
import com.bit.discount.FixDiscountPolicy;
import com.bit.member.Member;
import com.bit.member.MemberRepository;
import com.bit.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements  OrderService{
    private  final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy;

    //테스트용도
    public MemberRepository getMemberRepository(){
        return this.memberRepository;
    }
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,DiscountPolicy discountPolicy){
        this.memberRepository=memberRepository;
        this.discountPolicy=discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member= memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}

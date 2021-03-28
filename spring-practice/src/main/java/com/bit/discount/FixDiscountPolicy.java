package com.bit.discount;

import com.bit.member.Grade;
import com.bit.member.Member;

public class FixDiscountPolicy implements  DiscountPolicy{
    private  int FixDiscountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP)
            return FixDiscountFixAmount;
        else{
            return 0;
        }
    }
}

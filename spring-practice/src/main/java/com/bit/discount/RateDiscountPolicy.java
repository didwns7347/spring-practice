package com.bit.discount;

import com.bit.member.Grade;
import com.bit.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements  DiscountPolicy{
    private  int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price/100*discountPercent;
        }
        else{
            return 0;
        }

    }
}

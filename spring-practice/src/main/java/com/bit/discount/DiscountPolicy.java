package com.bit.discount;

import com.bit.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}

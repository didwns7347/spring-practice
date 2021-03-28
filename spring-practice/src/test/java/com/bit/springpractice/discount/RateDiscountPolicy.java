package com.bit.springpractice.discount;

import com.bit.discount.DiscountPolicy;
import com.bit.member.Grade;
import com.bit.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicy {
    DiscountPolicy discountPolicy = new com.bit.discount.RateDiscountPolicy();
    @Test
    @DisplayName("VIP는 10% 할인이 적용되야함")
    void vip_o(){
        //given
        Member member= new Member(1l,"memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);

    }
    @Test
    @DisplayName("VIP가 아니면 할인 적용 X")
    void vip_x(){
        Member member = new Member(2l, "memberBASIC", Grade.BASIC);

        int discount = discountPolicy.discount(member,10000);
        Assertions.assertThat(discount).isEqualTo(0);
    }

}

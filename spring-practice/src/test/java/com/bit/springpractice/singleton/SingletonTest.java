package com.bit.springpractice.singleton;

import com.bit.AppConfig;
import com.bit.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 호출시마다 새로운 객체 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 호출시마다 새로운 객체 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1= "+memberService1);
        System.out.println("memberService2= "+memberService2);
        //Assertions.assertThat(memberService1).isEqualTo(memberService2);
        //우리가 만든 DI컨테이너는 객체를 요청시마다 새로 생성해 낭비가 심함 =>한개만 생성해서 공유하도록 함(싱글톤)

    }
}

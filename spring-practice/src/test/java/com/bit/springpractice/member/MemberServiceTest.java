package com.bit.springpractice.member;

import com.bit.AppConfig;
import com.bit.member.Grade;
import com.bit.member.Member;
import com.bit.member.MemberService;
import com.bit.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join(){
        Member member = new Member(1l,"memberA", Grade.VIP);
        memberService.join(member);


        Member findMember = memberService.findMember(member.getId());
        Assertions.assertThat(member).isEqualTo(findMember);

    }

}

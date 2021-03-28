package com.bit;

import com.bit.member.Grade;
import com.bit.member.Member;
import com.bit.member.MemberService;
import com.bit.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args){
        AppConfig appConfig=new AppConfig();
        MemberService memberService= appConfig.memberService();
        Member member= new Member(1l,"memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        System.out.println("new Member"+member.getName());
        System.out.println("Find Member"+findMember.getName());
    }

}

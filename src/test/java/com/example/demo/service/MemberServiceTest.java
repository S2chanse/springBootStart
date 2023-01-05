package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;


    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("기러기2");

        //when
        Long returnId = memberService.join(member);
        Long compareId = memberService.findMember(member.getName()).get().getId();

        //then
        assertThat(returnId).isEqualTo(compareId);

    }

    @Test
    public void duplicateMemberException(){
        //given
        Member member1 = new Member();
        member1.setName("기러기");

        Member member2 = new Member();
        member2.setName("기러기");
        //when
        memberService.join(member1);
        //에러 처리 매서드
        IllegalStateException ise = assertThrows(IllegalStateException.class,()->memberService.join(member2));
        assertThat(ise.getMessage()).isEqualTo("이미 존재하는 유저입니다.");

//        try{
//            ms.join(member2);
//            fail("예외가 발생해야합니다.");
//        }catch(IllegalStateException ise){
//            assertThat(ise.getMessage()).isEqualTo("이미 존재하는 유저입니다.");
//        }
        //then
    }
    @Test
    void findMembers() {
    }

    @Test
    void findMember() {
    }
}
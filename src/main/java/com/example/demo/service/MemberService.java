package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    public final MemoryMemberRepository mmr;

    @Autowired
    public MemberService(MemoryMemberRepository mmr) {
        this.mmr = mmr;
    }

    /**
     * 회원가입
     */
    public Long join (Member member){
        validateDubplicate(member);//중복체크
        mmr.save(member);
        return member.getId();
    }

    private void validateDubplicate(Member member) {
        mmr.findByName(member.getName())
                .ifPresent(m->{//존재여부 확인
                    throw  new IllegalStateException("이미 존재하는 유저입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * */
    public List<Member> findMembers(Member member){
        return mmr.findAll();
    }
    /**
     * 회원 조회
     */
    public Optional<Member> findMember(String name){
        return mmr.findByName(name);
    }
}

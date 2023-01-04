package com.example.demo.repository;

import com.example.demo.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JPAMemberRepository implements MemberRepository{
    private EntityManager em;

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {

        Member member= em.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {

        return Optional.ofNullable(null);

    }

    @Override
    public List<Member> findAll() {

        return em.createQuery("select * from Member",Member.class).getResultList();
    }
}

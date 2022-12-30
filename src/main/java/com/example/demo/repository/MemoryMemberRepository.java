package com.example.demo.repository;

import com.example.demo.domain.Member;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long,Member> store = new ConcurrentHashMap<Long,Member>();
    private static long sequence = 0L;

    @Override
    public Member Save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return
                Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member->member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
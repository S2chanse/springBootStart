package com.example.demo.repository;

import com.example.demo.domain.Member;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JDBCMemberRepository implements MemberRepository{
    private DataSource datasource;

    public JDBCMemberRepository(DataSource dataSource) {
        this.datasource = dataSource;
    }

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}

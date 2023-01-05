package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.binding.QuerydslPredicate;

import java.util.Optional;

public interface SpringDataJPAMemberRepository extends JpaRepository<Member,Long>,MemberRepository {
    @Query("select m from member m where name = ?")
    @Override
    Optional<Member> findByName(String name);
}

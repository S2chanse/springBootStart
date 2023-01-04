package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "/members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(Member member){
        System.out.println(member.getName());
        long resultId = memberService.join(member);
        System.out.println(resultId);
        return "redirect:/";
    }

    @GetMapping("/members/list")
    public ModelAndView members(Member member){
        ModelAndView mv = new ModelAndView();
        List<Member> memberList = memberService.findMembers(member);
        mv.setViewName("/members/memberList");
        for (Member mem:  memberList) {
            System.out.format("%s",mem.getName());
        }
        mv.addObject("members",memberList);
        return mv;
    }
}

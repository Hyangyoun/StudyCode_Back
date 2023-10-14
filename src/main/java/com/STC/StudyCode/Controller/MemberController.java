package com.STC.StudyCode.Controller;

import com.STC.StudyCode.Dto.MemberDto;
import com.STC.StudyCode.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /** 회원 정보 조회 */
    @GetMapping(value = "/me")
    public MemberDto GetMember(@RequestParam String id) {
        return memberService.GetMember(id);
    }

    /** 회원 정보 입력 */
    @PostMapping(value = "/membership")
    public String Membership(@RequestBody MemberDto memberDto) {
        System.out.println(memberDto.getMemId());
        return memberService.Membership(memberDto);
    }

    @PostMapping(value = "/login")
    public String Login(@RequestParam String id, String password) {
        return memberService.Login(id, password);
    }
}

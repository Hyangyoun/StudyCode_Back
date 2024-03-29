package com.STC.StudyCode.Member.Controller;

import com.STC.StudyCode.Member.Dto.LoginDataDto;
import com.STC.StudyCode.Member.Service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/login")
    @Operation(summary = "로그인을 시도합니다.")
    public String Login(@RequestBody LoginDataDto loginDataDto) {
        return memberService.Login(loginDataDto);
    }
}

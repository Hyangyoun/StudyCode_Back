package com.STC.StudyCode.Member.Service;

import com.STC.StudyCode.Entity.MemberEntity;
import com.STC.StudyCode.Member.Dto.LoginDataDto;
import com.STC.StudyCode.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public String Login(LoginDataDto loginDataDto) {
        Optional<MemberEntity> memberEntity = memberRepository.findById(loginDataDto.getMemId());

        if(memberEntity.isPresent()) {
            if(memberEntity.get().getPassword().equals(loginDataDto.getPassword())) {
                return memberEntity.get().getNickname();
            }
            else return null;
        }
        else return null;
    }
}

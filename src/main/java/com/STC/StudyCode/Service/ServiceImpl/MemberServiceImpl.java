package com.STC.StudyCode.Service.ServiceImpl;

import com.STC.StudyCode.Dto.MemberDto;
import com.STC.StudyCode.Entity.MemberEntity;
import com.STC.StudyCode.Repository.MemberRepository;
import com.STC.StudyCode.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /** id에 해당하는 회원정보 획득 */
    @Override
    public MemberDto GetMember(String id) {
        Optional<MemberEntity> memberEntity = memberRepository.findById(id);
        if(memberEntity.isPresent()){
            return memberEntity.get().toDto();
        }
        else return null;
    }

    /** 회원가입 페이지를 통한 회원정보 데이터베이스에 입력 */
    @Override
    public String Membership(MemberDto memberDto) {
        MemberEntity memberEntity = memberDto.toEntity();
        memberRepository.save(memberEntity);
        return "성공";
    }

    @Override
    public String Login(String id, String password) {
        Optional<MemberEntity> memberEntity = memberRepository.findById(id);
        if (memberEntity.isPresent()) {
            if(memberEntity.get().getPassword().equals(password)) {
                return memberEntity.get().getNickname();
            }
            else return null;
        }
        else return null;
    }


}

package com.STC.StudyCode.Member.Dto;

import com.STC.StudyCode.Entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    private String memId;
    private String password;
    private String nickname;
    private String email;
    private String profilePicture;
    private String joinDate;
    private String social;

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .memId(memId)
                .password(password)
                .nickname(nickname)
                .email(email)
                .profilePicture(profilePicture)
                .joinDate(joinDate)
                .social(social)
                .build();
    }
}

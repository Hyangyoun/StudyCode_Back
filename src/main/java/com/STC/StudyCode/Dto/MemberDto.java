package com.STC.StudyCode.Dto;

import com.STC.StudyCode.Entity.MemberEntity;
import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberDto {
    private String memId;
    private String password;
    private String nickname;
    private String email;
    private String profilePicture;
    private Date joinDate;
    private boolean social;

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

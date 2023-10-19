package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Dto.MemberDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Member")
public class MemberEntity {

    @Id
    @Column(name = "mem_id")
    private String memId;
    private String password;
    private String nickname;
    private String email;
    @Column(name = "profile_picture")
    private String profilePicture;
    @Column(name = "join_date")
    private Date joinDate;
    private boolean social;

    public MemberDto toDto() {
        return MemberDto.builder()
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

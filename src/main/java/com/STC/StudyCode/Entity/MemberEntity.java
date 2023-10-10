package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Dto.MemberDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Member")
public class MemberEntity {

    @Id
    @Column(name = "mem_id")
    String memId;
    String password;
    String nickname;
    String email;
    @Column(name = "profile_picture")
    String profilePicture;
    @Column(name = "join_date")
    Date joinDate;
    boolean social;

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

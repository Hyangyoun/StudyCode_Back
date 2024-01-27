package com.STC.StudyCode.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private String joinDate;
    private String social;
}

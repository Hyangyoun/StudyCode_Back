package com.STC.StudyCode.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BlogFllow")
public class BlogFllowEntity {

    @Id
    @Column(name = "blog_index")
    int blogIndex;
    @Id
    @Column(name = "mem_id")
    String memId;
}

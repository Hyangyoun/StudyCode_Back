package com.STC.StudyCode.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BlogFllow")
public class BlogFllowEntity {

    @Id
    @Column(name = "blog_index")
    private int blogIndex;
    @Id
    @Column(name = "mem_id")
    private String memId;
}

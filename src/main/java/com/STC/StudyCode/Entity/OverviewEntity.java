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
@Table(name = "Overview")
public class OverviewEntity {

    @Id
    @Column(name = "blog_index")
    int blogIndex;
    String content;
}

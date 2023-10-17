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
    @Column(name = "mem_id")
    String memId;
    String content;
}

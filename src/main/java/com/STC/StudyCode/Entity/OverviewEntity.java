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
@Table(name = "Overview")
public class OverviewEntity {

    @Id
    @Column(name = "mem_id")
    private String memId;
    private String content;
}

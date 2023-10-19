package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Dto.OverviewDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.sql.ast.tree.expression.Over;

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

    public OverviewDto toDto() {
        return OverviewDto.builder()
                .memId(memId)
                .content(content)
                .build();
    }
}

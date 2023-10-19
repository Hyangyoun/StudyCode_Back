package com.STC.StudyCode.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BlogCategory")
public class BlogCategoryEntity {

    @Id
    @Column(name = "category_name")
    private String categoryName;
    @Id
    @Column(name = "mem_id")
    private String memId;
}

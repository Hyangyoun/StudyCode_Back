package com.STC.StudyCode.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "BlogCategory")
public class BlogCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_index")
    private Integer categoryIndex;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "blog_index")
    private Integer blogIndex;
}

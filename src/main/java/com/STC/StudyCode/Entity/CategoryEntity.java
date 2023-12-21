package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Entity.Id.CategoryId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(CategoryId.class)
@Table(name = "BlogCategory")
public class CategoryEntity {
    @Id
    @Column(name = "category_name")
    private String categoryName;
    @Id
    @Column(name = "mem_id")
    private String memId;
}

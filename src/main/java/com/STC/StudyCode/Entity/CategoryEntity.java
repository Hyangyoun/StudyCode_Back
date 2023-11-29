package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Entity.Id.CategoryId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(CategoryId.class)
public class CategoryEntity {
    @Id
    @Column(name = "category_name")
    private String categoryName;
    @Id
    @Column(name = "mem_id")
    private String memId;
}

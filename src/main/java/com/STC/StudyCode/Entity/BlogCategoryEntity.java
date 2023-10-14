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
@Table(name = "BlogCategory")
public class BlogCategoryEntity {

    @Id
    @Column(name = "category_name")
    String categoryName;
    @Column(name = "blog_index")
    int blogIndex;
}

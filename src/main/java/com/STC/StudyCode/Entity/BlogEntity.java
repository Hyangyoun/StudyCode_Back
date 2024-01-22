package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Blog.Dto.BlogDto;
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
@Table(name = "Blog")
public class BlogEntity {
    @Id
    @Column(name = "mem_id")
    private String memId;
    private String name;
    private Integer skin;
    private Integer followers;
    private String overview;

    public BlogDto toDto() {
        return BlogDto.builder()
                .memId(memId)
                .name(name)
                .skin(skin)
                .followers(followers)
                .overview(overview)
                .build();
    }
}

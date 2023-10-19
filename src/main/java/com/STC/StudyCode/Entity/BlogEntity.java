package com.STC.StudyCode.Entity;

import com.STC.StudyCode.Dto.BlogDto;
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
@Table(name = "Blog")
public class BlogEntity {

    @Id
    @Column(name = "mem_id")
    private String memId;
    private String name;
    private int skin;
    private int followers;

    public BlogDto toDto() {
        return BlogDto.builder()
                .memId(memId)
                .name(name)
                .skin(skin)
                .followers(followers)
                .build();
    }
}

package com.STC.StudyCode.Entity.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostLikeId implements Serializable {
    private String memId;
    private Integer postIndex;
}

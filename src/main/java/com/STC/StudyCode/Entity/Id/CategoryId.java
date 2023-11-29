package com.STC.StudyCode.Entity.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryId implements Serializable {
    private String categoryName;
    private String memId;
}

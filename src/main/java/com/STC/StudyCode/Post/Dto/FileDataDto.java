package com.STC.StudyCode.Post.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileDataDto {
    private String fileName;
    private String filePath;
}

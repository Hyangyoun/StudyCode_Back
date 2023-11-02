package com.STC.StudyCode.Dto;

import java.util.Date;

public interface PostListDto {
    int getPostIndex();
    String getTitle();
    String getContent();
    int getLike();
    Date getDate();
}

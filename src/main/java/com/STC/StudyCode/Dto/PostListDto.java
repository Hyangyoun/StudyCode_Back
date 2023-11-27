package com.STC.StudyCode.Dto;

import java.util.Date;

public interface PostListDto {
    Integer getPostIndex();
    String getTitle();
    String getContent();
    Integer getRecommend();
    Date getDate();
}

package com.STC.StudyCode.Dto;

import java.sql.Date;

public interface PostInfoDto {
    String getNickName();
    String getBlogName();
    String getCategoryName();
    String getTitle();
    String getContent();
    int getLike();
    Date getPostDate();
}

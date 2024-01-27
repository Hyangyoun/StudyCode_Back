package com.STC.StudyCode.Blog.Service;

import com.STC.StudyCode.Blog.Dto.BlogConfigDto;
import com.STC.StudyCode.Blog.Dto.BlogDto;
import com.STC.StudyCode.Blog.Dto.BlogInfoDto;

public interface BlogService {
    BlogInfoDto BlogInfo(String nickname);
    BlogConfigDto BlogConfig(Integer blogIndex);
    void SaveConfig(BlogDto blogDto);
}

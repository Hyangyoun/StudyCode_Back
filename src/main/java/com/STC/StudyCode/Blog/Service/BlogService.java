package com.STC.StudyCode.Blog.Service;

import com.STC.StudyCode.Blog.Dto.BlogConfigDto;
import com.STC.StudyCode.Blog.Dto.BlogDto;

public interface BlogService {
    BlogDto BlogInfo(String nickname);

    BlogConfigDto BlogConfig(String memId);

    void RegistOverview(String memId, String overView);
}

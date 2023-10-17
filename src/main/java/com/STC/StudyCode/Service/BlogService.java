package com.STC.StudyCode.Service;

import com.STC.StudyCode.Dto.BlogDto;
import com.STC.StudyCode.Dto.OverviewDto;
import com.STC.StudyCode.Dto.PostDto;

import java.util.List;

public interface BlogService {
    /** 소개글(Overview) 등록 */
    public String RegistOverview(OverviewDto overviewDto);

    public BlogDto GetBlogInfo(String memId);

    public List<PostDto> PostList(String memId);
}

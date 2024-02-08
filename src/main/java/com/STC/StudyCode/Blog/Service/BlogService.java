package com.STC.StudyCode.Blog.Service;

import com.STC.StudyCode.Blog.Dto.*;

import java.util.List;

public interface BlogService {
    BlogInfoDto BlogInfo(Long blogIndex);
    BlogConfigDto BlogConfig(Integer blogIndex);
    void SaveConfig(BlogDto blogDto);
    List<String> TagList(Long blogIndex);
    void RegistOverView(OverViewDataDto overViewDataDto);
    CheckBlogDto CheckBlog(AccessBlogDto accessBlogDto);
}

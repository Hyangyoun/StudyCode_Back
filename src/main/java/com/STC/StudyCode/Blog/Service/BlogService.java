package com.STC.StudyCode.Blog.Service;

import com.STC.StudyCode.Blog.Dto.BlogConfigDto;
import com.STC.StudyCode.Blog.Dto.BlogDto;

public interface BlogService {
    /** 블로그 정보 */
    BlogDto BlogInfo(String nickname);
    /** 블로그 설정 */
    BlogConfigDto BlogConfig(String memId);
    /**블로그 오버뷰 등록 */
    void RegistOverview(String memId, String overView);
    /**블로그 설정 저장 */
    void SaveBlogConfig(BlogDto blogDto);
}

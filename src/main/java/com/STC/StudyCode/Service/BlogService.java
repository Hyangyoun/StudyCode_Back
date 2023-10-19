package com.STC.StudyCode.Service;

import com.STC.StudyCode.Dto.*;

import java.util.List;

public interface BlogService {
    /** 소개글(Overview) 등록 */
    public String RegistOverview(OverviewDto overviewDto);

    /** 소개글(Overview) 조회 */
    public OverviewDto GetOverview(String memId);

    /** 블로그 정보 요청 */
    public BlogDto GetBlogInfo(String memId);

    /** 특정 멤버 포스트 목록 요청 */
    public List<PostDto> PostList(String memId);

    /** 레포지토리 폴더 목록 요청 */
    public List<RepFolderDto> GetRepo(String memId);

    /** 레토지토리 폴더 등록 */
    public String RegistRepo(RepFolderDto repFolderDto);

    /** 레포지토리 파일 등록 */
    public String RegistFile(RepositoryDto repositoryDto);

    /** 특정 멤버 레포지토리 파일목록 요청 */
    public List<RepositoryDto> GetFile(String memId);
}

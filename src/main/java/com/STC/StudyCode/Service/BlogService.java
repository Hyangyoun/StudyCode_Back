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

    /** 포스트 정보 요청 */
    public PostDto PostInfo(int postIndex);

    /** 특정 멤버 포스트 목록 요청 */
    public List<PostListDto> PostList(String memId);

    /** 포스트 태그 목록 요청 */
    public List<PostTagListDto> PostTagList(int postIndex);

    /** 포스트 파일 목록 요청 */
    public List<PostRepoDto> PostRepoList(int postIndex);

    /** 레포지토리 폴더 목록 요청 */
    public List<RepFolderDto> GetRepo(String memId);

    /** 레토지토리 폴더 등록 */
    public String RegistRepo(RepFolderDto repFolderDto);

    /** 레포지토리 파일 등록 */
    public String RegistFile(RepositoryDto repositoryDto);

    /** 특정 멤버 레포지토리 파일목록 요청 */
    public List<RepositoryDto> GetFile(String memId);

    /** 포스트 댓글 리스트 요청 */
    public List<Object> GetComment(Integer postIndex);
}

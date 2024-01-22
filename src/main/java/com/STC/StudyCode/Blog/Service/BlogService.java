package com.STC.StudyCode.Blog.Service;

import com.STC.StudyCode.Blog.Dto.*;

import java.util.List;

public interface BlogService {
    /** 블로그 정보 */
    BlogDto BlogInfo(String nickname);
    /** 블로그 설정 */
    BlogConfigDto BlogConfig(String memId);
    /**블로그 오버뷰 등록 */
    void RegistOverview(String memId, String overView);
    /**블로그 설정 저장 */
    void SaveBlogConfig(BlogDto blogDto);
    /** 레포지토리 폴더 목록 */
    List<String> FolderList(String nickname);
    /** 레포지토리 폴더 추가 */
    void AddFolder(RepFolderDto repFolderDto);
    /** 레포지토리 파일 목록 */
    List<RepositoryFileInfoDto> FileList(String nickname, String folderName);
    /** 카테고리 정보 */
    List<CategoryInfoDto> CategoryInfo(String nickname);
    /** 카테고리 추가 */
    void AddCategory(CategoryDto categoryDto);
}

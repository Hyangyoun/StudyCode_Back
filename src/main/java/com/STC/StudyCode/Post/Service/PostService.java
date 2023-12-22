package com.STC.StudyCode.Post.Service;

import com.STC.StudyCode.Blog.Dto.CategoryInfoDto;
import com.STC.StudyCode.Blog.Dto.RepFolderDto;
import com.STC.StudyCode.Blog.Dto.RepositoryDto;
import com.STC.StudyCode.Entity.CategoryEntity;
import com.STC.StudyCode.Post.Dto.PostDto;
import com.STC.StudyCode.Post.Dto.PostInfoDto;
import com.STC.StudyCode.Post.Dto.PostListDto;
import com.STC.StudyCode.Post.Dto.PostTagDto;

import java.lang.reflect.Array;
import java.util.List;

public interface PostService {
    List<PostListDto> PostList(String nickname);
    PostInfoDto PostInfo(Integer postIndex);
    Integer RegistPost(PostDto postDto);
    void RegistTag(List<PostTagDto> postTagDtos);
    void RegistFile(RepositoryDto repositoryDto);
}

package com.STC.StudyCode.Service;

import com.STC.StudyCode.Post.Dto.PostListDto;

import java.util.List;

public interface PostService {
    List<PostListDto> PostList(String nickname);
}

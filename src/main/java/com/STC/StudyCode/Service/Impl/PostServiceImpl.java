package com.STC.StudyCode.Service.Impl;

import com.STC.StudyCode.Post.Dto.PostListDto;
import com.STC.StudyCode.Repository.PostRepository;
import com.STC.StudyCode.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostListDto> PostList(String nickname) {
        return postRepository.GetPostList(nickname);
    }
}

package com.STC.StudyCode.Post.Service;

import com.STC.StudyCode.Entity.PostEntity;
import com.STC.StudyCode.Entity.PostToPostTagEntity;
import com.STC.StudyCode.Post.Dto.PostToTagDto;
import com.STC.StudyCode.Repository.PostRepository;
import com.STC.StudyCode.Repository.PostToPostTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    PostToPostTagRepository postToPostTagRepository;
    PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostToPostTagRepository postToPostTagRepository, PostRepository postRepository) {
        this.postToPostTagRepository = postToPostTagRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<PostToTagDto> PostInfo(Integer postIndex) {
        return postToPostTagRepository.PostInfo(postIndex);
    }

    @Override
    @Transactional
    public PostEntity test(Long index) {
        Optional<PostEntity> postEntity = postRepository.findById(index);
        return postEntity.get();
    }
}
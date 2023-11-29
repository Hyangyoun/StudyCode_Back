package com.STC.StudyCode.Service.Impl;

import com.STC.StudyCode.Entity.PostTagEntity;
import com.STC.StudyCode.Post.Dto.PostDto;
import com.STC.StudyCode.Post.Dto.PostInfoDto;
import com.STC.StudyCode.Post.Dto.PostListDto;
import com.STC.StudyCode.Post.Dto.PostTagDto;
import com.STC.StudyCode.Repository.PostRepository;
import com.STC.StudyCode.Repository.PostTagRepository;
import com.STC.StudyCode.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {
    PostRepository postRepository;
    PostTagRepository postTagRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostTagRepository postTagRepository) {
        this.postRepository = postRepository;
        this.postTagRepository = postTagRepository;
    }

    /** 포스트 리스트 요청 */
    @Override
    public List<PostListDto> PostList(String nickname) {
        return postRepository.GetPostList(nickname);
    }

    @Override
    public List<PostTagDto> PostListTag(String nickname) {
        List<PostTagEntity> postTagEntities = postTagRepository.GetPostListTag(nickname);

        if(postTagEntities.isEmpty()) {
            return null;
        } else {
            List<PostTagDto> postTagDtos = new ArrayList<PostTagDto>();
            for(PostTagEntity postTagEntity : postTagEntities) {
                postTagDtos.add((postTagEntity.toDto()));
            }
            return postTagDtos;
        }
    }

    /** 포스트 상세정보 요청 */
    @Override
    public PostInfoDto PostInfo(Integer postIndex) {
        return postRepository.GetPostInfo(postIndex);
    }

    /** 포스트 태그정보 요청 */
    @Override
    public List<PostTagDto> PostTag(Integer postIndex) {
        List<PostTagEntity> postTagEntities = postTagRepository.findByPostIndex(postIndex);

        if(postTagEntities.isEmpty()) {
            return null;
        } else {
            List<PostTagDto> postTagDtos = new ArrayList<PostTagDto>();
            for(PostTagEntity postTagEntiy : postTagEntities) {
                postTagDtos.add(postTagEntiy.toDto());
            }
            return postTagDtos;
        }
    }
}
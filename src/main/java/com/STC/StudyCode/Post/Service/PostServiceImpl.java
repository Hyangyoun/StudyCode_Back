package com.STC.StudyCode.Post.Service;

import com.STC.StudyCode.Post.Dto.PostInfoDto;
import com.STC.StudyCode.Post.Dto.PostToTagInfoDto;
import com.STC.StudyCode.Repository.PostRepository;
import com.STC.StudyCode.Repository.PostTagRepository;
import com.STC.StudyCode.Repository.PostToPostTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    PostToPostTagRepository postToPostTagRepository;
    PostRepository postRepository;
    PostTagRepository postTagRepository;

    @Autowired
    public PostServiceImpl(PostToPostTagRepository postToPostTagRepository, PostRepository postRepository,
                           PostTagRepository postTagRepository) {
        this.postToPostTagRepository = postToPostTagRepository;
        this.postRepository = postRepository;
        this.postTagRepository = postTagRepository;
    }

    private List<PostToTagInfoDto> TagInPost(List<PostInfoDto> postInfoDtos, List<PostToTagInfoDto> postToTagInfoDtos) {
        for(PostInfoDto postInfoDto : postInfoDtos) {
            List<String> tag = postTagRepository.PostInfoTag(postInfoDto.getPostIndex());
            postToTagInfoDtos.add(PostToTagInfoDto.builder()
                    .postIndex(postInfoDto.getPostIndex())
                    .title(postInfoDto.getTitle())
                    .content(postInfoDto.getContent())
                    .recommend(postInfoDto.getRecommend())
                    .postDate(postInfoDto.getPostDate())
                    .thumbnailPath(postInfoDto.getThumbnailPath())
                    .tag(tag)
                    .build());
        }
        return postToTagInfoDtos;
    }

    @Override
    public PostToTagInfoDto PostInfo(Long postIndex) {
        PostInfoDto postInfoDto = postRepository.PostInfo(postIndex);

        if(postInfoDto != null) {
            List<String> tag = postTagRepository.PostInfoTag(postInfoDto.getPostIndex());
            PostToTagInfoDto postToTagInfoDto = PostToTagInfoDto.builder()
                    .postIndex(postInfoDto.getPostIndex())
                    .title(postInfoDto.getTitle())
                    .content(postInfoDto.getContent())
                    .recommend(postInfoDto.getRecommend())
                    .postDate(postInfoDto.getPostDate())
                    .thumbnailPath(postInfoDto.getThumbnailPath())
                    .tag(tag)
                    .build();
            return postToTagInfoDto;
        }
        else return null;
    }

    @Override
    public List<PostToTagInfoDto> PostList(Long blogIndex) {
        List<PostInfoDto> postInfoDtos = postRepository.PostList(blogIndex);
        List<PostToTagInfoDto> postList = new ArrayList<PostToTagInfoDto>();
        if(postInfoDtos != null) {
            return TagInPost(postInfoDtos, postList);
        }
        else return null;
    }

    @Override
    public List<PostToTagInfoDto> TagToPostList(Long blogIndex, String tagName) {
        List<PostInfoDto> postInfoDtos = postToPostTagRepository.TagToPostList(blogIndex, tagName);
        List<PostToTagInfoDto> postToTagInfoDtos = new ArrayList<PostToTagInfoDto>();

        if(postInfoDtos != null) {
            return TagInPost(postInfoDtos, postToTagInfoDtos);
        }
        else return null;
    }

    @Override
    public void test(Long index) {

    }
}
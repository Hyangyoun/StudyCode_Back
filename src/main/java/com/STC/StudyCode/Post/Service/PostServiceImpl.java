package com.STC.StudyCode.Post.Service;

import com.STC.StudyCode.Entity.*;
import com.STC.StudyCode.Post.Dto.*;
import com.STC.StudyCode.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    PostToPostTagRepository postToPostTagRepository;
    PostRepository postRepository;
    PostTagRepository postTagRepository;
    PostCommentRepository postCommentRepository;
    RepoRepository repoRepository;

    @Autowired
    public PostServiceImpl(PostToPostTagRepository postToPostTagRepository, PostRepository postRepository,
                           PostTagRepository postTagRepository, PostCommentRepository postCommentRepository,
                           RepoRepository repoRepository) {
        this.postToPostTagRepository = postToPostTagRepository;
        this.postRepository = postRepository;
        this.postTagRepository = postTagRepository;
        this.postCommentRepository = postCommentRepository;
        this.repoRepository = repoRepository;
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
                    .nickname(postInfoDto.getNickname())
                    .blogName(postInfoDto.getBlogName())
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
    public List<PostToTagInfoDto> PostList(Long blogIndex, Long categoryIndex) {
        List<PostInfoDto> postInfoDtos = postRepository.CategoryPostList(blogIndex, categoryIndex);
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
    public List<CommentListDto> CommentList(Long postIndex) {
        List<CommentDto> commentDtos = postCommentRepository.CommentList(postIndex);
        List<CommentListDto> commentListDtos = new ArrayList<CommentListDto>();

        if(commentDtos != null) {
            for(CommentDto commentDto : commentDtos) {
                commentListDtos.add(CommentListDto.builder()
                        .commentIndex(commentDto.getCommentIndex())
                        .content(commentDto.getContent())
                        .commentDate(commentDto.getCommentDate())
                        .nickname(commentDto.getNickname())
                        .profilePath(commentDto.getProfilePath())
                        .reply(postCommentRepository.ReplyList(commentDto.getCommentIndex()))
                        .build());
            }
            return commentListDtos;
        }
        else return null;
    }

    @Override
    public void RegistComment(RegistCommentDto registCommentDto) {
        postCommentRepository.save(PostCommentEntity.builder()
                .postIndex(registCommentDto.getPostIndex())
                .memId(registCommentDto.getMemId())
                .content(registCommentDto.getContent())
                .commentDate(LocalDateTime.now().toString())
                .build());
    }

    @Override
    public void RegistReply(RegistCommentDto registCommentDto) {
        postCommentRepository.save(PostCommentEntity.builder()
                .postIndex(registCommentDto.getPostIndex())
                .memId(registCommentDto.getMemId())
                .content(registCommentDto.getContent())
                .parentIndex(registCommentDto.getComment_index())
                .commentDate(LocalDateTime.now().toString())
                .build());
    }

    @Override
    public Long RegistPost(PostDto postDto) {
        PostEntity postEntity = postDto.toEntity();
        postEntity.setPostDate(LocalDateTime.now().toString());
        postEntity.setRecommend(0);
        return postRepository.save(postEntity).getPostIndex();
    }

    @Override
    public void PostFile(List<FileDataDto> fileDataDtos, Long postIndex, Long blogIndex) {
        for(FileDataDto fileDataDto : fileDataDtos) {
            repoRepository.save(RepositoryEntity.builder()
                    .postIndex(postIndex)
                    .blogIndex(blogIndex)
                    .fileName(fileDataDto.getFileName())
                    .filePath(fileDataDto.getFilePath())
                    .type(RepositoryType.D)
                    .build());
        }

    }

    @Override
    @Transactional
    public void PostThumbnail(String thumbnailPath, Long postIndex) {
        Optional<PostEntity> postEntity = postRepository.findById(postIndex);
        postEntity.get().setThumbnailPath(thumbnailPath);
    }

    @Override
    public void PostTag(List<String> tags, Long postIndex, Long blogIndex) {
        for (String tag : tags) {
            if(postTagRepository.existsByTagName(tag)) {
                postToPostTagRepository.save(PostToPostTagEntity.builder()
                        .postIndex(postIndex)
                        .tagIndex(postTagRepository.GetTagId(tag))
                        .blogIndex(blogIndex)
                        .build());
            }
            else {
                Long tagIndex = postTagRepository.save(PostTagEntity.builder()
                        .tagName(tag)
                        .build()).getTagIndex();
                postToPostTagRepository.save(PostToPostTagEntity.builder()
                        .postIndex(postIndex)
                        .tagIndex(tagIndex)
                        .blogIndex(blogIndex)
                        .build());
            }
        }
    }

    @Override
    public void test(Long index) {

    }
}
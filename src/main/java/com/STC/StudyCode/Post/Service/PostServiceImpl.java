package com.STC.StudyCode.Post.Service;

import com.STC.StudyCode.Blog.Dto.RepositoryDto;
import com.STC.StudyCode.Entity.PostEntity;
import com.STC.StudyCode.Entity.PostTagEntity;
import com.STC.StudyCode.Post.Dto.*;
import com.STC.StudyCode.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PostServiceImpl implements PostService {
    PostRepository postRepository;
    PostTagRepository postTagRepository;
    RepFolderRepository repFolderRepository;
    RepoRepository repoRepository;
    CategoryRepository categoryRepository;
    PostCommentRepository postCommentRepository;
    PostReplyRepository postReplyRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostTagRepository postTagRepository,
                           RepFolderRepository repFolderRepository, RepoRepository repoRepository,
                           CategoryRepository categoryRepository, PostCommentRepository postCommentRepository,
                           PostReplyRepository postReplyRepository) {
        this.postRepository = postRepository;
        this.postTagRepository = postTagRepository;
        this.repFolderRepository = repFolderRepository;
        this.repoRepository = repoRepository;
        this.categoryRepository = categoryRepository;
        this.postCommentRepository = postCommentRepository;
        this.postReplyRepository = postReplyRepository;
    }

    /** 포스트 리스트 요청 */
    @Override
    public List<PostListDto> PostList(String nickname) {
        List<PostEntity> postEntities = postRepository.GetPostList(nickname);
        List<PostListDto> postListDtos = new ArrayList<PostListDto>();

        if(postEntities != null) {
            for(PostEntity postEntity : postEntities) {
                List<String> postTag = new ArrayList<String>(postEntity.getTag().stream().map(tag -> tag.getTagName()).toList());
                postListDtos.add(PostListDto.builder()
                        .postIndex(postEntity.getPostIndex())
                        .title(postEntity.getTitle())
                        .content(postEntity.getContent())
                        .recommend(postEntity.getRecommend())
                        .postDate(postEntity.getPostDate())
                        .thumbnailPath(postEntity.getThumbnailPath())
                        .tagName(postTag)
                        .build());
            }
            return postListDtos;
        }
        else return null;
    }

    /** 포스트 상세정보 요청 */
    @Override
    public PostInfoDto PostInfo(Integer postIndex) {
        Optional<PostEntity> postEntity = postRepository.GetPostInfo(postIndex);
        if(postEntity.isPresent()) {
            List<String> postTag = new ArrayList<>(postEntity.get().getTag().stream().map(tag -> tag.getTagName()).toList());
            PostUserDto postUserDto = postRepository.GetPostUser(postIndex);
            return PostInfoDto.builder()
                    .title(postEntity.get().getTitle())
                    .content(postEntity.get().getContent())
                    .recommend(postEntity.get().getRecommend())
                    .postDate(postEntity.get().getPostDate())
                    .nickname(postUserDto.getNickname())
                    .blogName(postUserDto.getBlogName())
                    .tagName(postTag)
                    .build();
        }
        else return null;
    }

    @Override
    public Integer RegistPost(PostDto postDto) {
        postDto.setPostDate(LocalDateTime.now().toString());
        postDto.setRecommend(0);
        return postRepository.save(postDto.toEntity()).getPostIndex();
    }

    @Override
    public void RegistTag(List<PostTagDto> postTagDtos) {
        List<PostTagEntity> postTagEntities = new ArrayList<PostTagEntity>();

        for(PostTagDto postTagDto : postTagDtos) {
            postTagEntities.add(postTagDto.toEntity());
        }

        postTagRepository.saveAll(postTagEntities);
    }

    @Override
    public void RegistFile(RepositoryDto repositoryDto) {
        repoRepository.save(repositoryDto.toEntity());
    }

    /** 댓글 정보 요청 */
    @Override
    public List<CommentDto> getComment(Integer postIndex) {
        List<CommentInfoDto> commentInfoDtos = postCommentRepository.findComment(postIndex);
        List<CommentDto> commentDtos = new ArrayList<CommentDto>();

        if(commentInfoDtos != null) {
            for(CommentInfoDto commentInfoDto : commentInfoDtos) {
                List<ReplyInfoDto> reply = postReplyRepository.findReply(commentInfoDto.getCommentIndex());
                commentDtos.add(CommentDto.builder()
                        .commentIndex(commentInfoDto.getCommentIndex())
                        .nickname(commentInfoDto.getNickname())
                        .content(commentInfoDto.getContent())
                        .commentDate(commentInfoDto.getCommentDate())
                        .reply(reply)
                        .build());
            }
            return commentDtos;
        }
        else return null;
    }

    /** 댓글 등록 */
    @Override
    public void RegistComment(PostCommentDto postCommentDto) {
        postCommentDto.setCommentDate(LocalDateTime.now().toString());
        postCommentRepository.save(postCommentDto.toEntity());
    }

    /** 대댓글 등록 */
    @Override
    public void RegistReply(PostReplyDto postReplyDto) {
        postReplyDto.setCommentDate(LocalDateTime.now().toString());
        postReplyRepository.save(postReplyDto.toEntity());
    }
}
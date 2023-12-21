package com.STC.StudyCode.Post.Service;

import com.STC.StudyCode.Blog.Dto.CategoryDto;
import com.STC.StudyCode.Blog.Dto.CategoryInfoDto;
import com.STC.StudyCode.Blog.Dto.RepositoryDto;
import com.STC.StudyCode.Entity.CategoryEntity;
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

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostTagRepository postTagRepository,
                           RepFolderRepository repFolderRepository, RepoRepository repoRepository,
                           CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.postTagRepository = postTagRepository;
        this.repFolderRepository = repFolderRepository;
        this.repoRepository = repoRepository;
        this.categoryRepository = categoryRepository;
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

    @Override
    public String[] FolderList(String memId) {
        return repFolderRepository.GetFolderList(memId);
    }

    @Override
    public List<CategoryInfoDto> CategoryInfo(String nickname) {
        List<CategoryEntity> categoryEntities = categoryRepository.findCategory(nickname);
        List<CategoryInfoDto> categoryInfoDtos = new ArrayList<CategoryInfoDto>();
        if(categoryEntities != null) {
            for (CategoryEntity categoryEntity : categoryEntities) {
                List<ThumbnailPathDto> thumbnailPathDtos = postRepository.GetCategory(categoryEntity.getCategoryName(), nickname);
                List<String> thumbnailPath = new ArrayList<String>(thumbnailPathDtos.stream().map(path -> path.getThumbnailPath()).toList());
                categoryInfoDtos.add(CategoryInfoDto.builder()
                        .categoryName(categoryEntity.getCategoryName())
                        .thumbnailPath(thumbnailPath)
                        .postCount(postRepository.GetCategorytoCount(categoryEntity.getCategoryName(), nickname))
                        .build());
            }
            return categoryInfoDtos;
        }
        else return null;
    }
}
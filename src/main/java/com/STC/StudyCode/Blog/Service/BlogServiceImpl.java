package com.STC.StudyCode.Blog.Service;

import com.STC.StudyCode.Blog.Dto.BlogConfigDto;
import com.STC.StudyCode.Blog.Dto.BlogDto;
import com.STC.StudyCode.Blog.Dto.CategoryInfoDto;
import com.STC.StudyCode.Blog.Dto.RepositoryFileInfoDto;
import com.STC.StudyCode.Entity.BlogEntity;
import com.STC.StudyCode.Entity.CategoryEntity;
import com.STC.StudyCode.Post.Dto.ThumbnailPathDto;
import com.STC.StudyCode.Repository.*;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    BlogRepository blogRepository;
    RepFolderRepository repFolderRepository;
    CategoryRepository categoryRepository;
    PostRepository postRepository;
    RepoRepository repoRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository, RepFolderRepository repFolderRepository,
                           CategoryRepository categoryRepository, PostRepository postRepository,
                           RepoRepository repoRepository) {
        this.blogRepository = blogRepository;
        this.repFolderRepository = repFolderRepository;
        this.categoryRepository = categoryRepository;
        this.postRepository = postRepository;
        this.repoRepository = repoRepository;
    }

    /** 블로그 정보 요청 */
    @Override
    public BlogDto BlogInfo(String nickname) {
        Optional<BlogEntity> blogEntity = blogRepository.GetBlogInfo(nickname);

        if(blogEntity.isPresent()) {
            return blogEntity.get().toDto();
        }
        else return null;
    }

    /** 블로그 설정 정보 요청 */
    @Override
    public BlogConfigDto BlogConfig(String memId) {
        BlogConfigDto blogConfigDto = blogRepository.GetBlogOption(memId);

        if(blogConfigDto != null) {
            return blogConfigDto;
        }
        else return null;
    }

    /** 오버뷰 등록 */
    @Override
    public void RegistOverview(String memId, String overView) {
        blogRepository.UpdateOverview(memId, overView);
    }

    @Override
    public void SaveBlogConfig(BlogDto blogDto) {
        blogRepository.UpdateConfig(blogDto.getMemId(), blogDto.getName(), blogDto.getSkin(), blogDto.getOverview());
    }

    /** 레포지토리 폴더 목록 요청 */
    @Override
    public List<String> FolderList(String nickname) {
        return repFolderRepository.GetFolderList(nickname);
    }

    /** 레포지토리 파일 목록 요청 */
    @Override
    public List<RepositoryFileInfoDto> FileList(String nickname, String folderName) {
        return repoRepository.GetFile(nickname, folderName);
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
package com.STC.StudyCode.Blog.Service;

import com.STC.StudyCode.Blog.Dto.BlogConfigDto;
import com.STC.StudyCode.Blog.Dto.BlogDto;
import com.STC.StudyCode.Blog.Dto.BlogInfoDto;
import com.STC.StudyCode.Blog.Dto.ConfigInfoDto;
import com.STC.StudyCode.Entity.BlogCategoryEntity;
import com.STC.StudyCode.Repository.BlogCategoryRepository;
import com.STC.StudyCode.Repository.BlogRepository;
import com.STC.StudyCode.Repository.PostTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    BlogRepository blogRepository;
    BlogCategoryRepository blogCategoryRepository;
    PostTagRepository postTagRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository, BlogCategoryRepository blogCategoryRepository,
                           PostTagRepository postTagRepository) {
        this.blogRepository = blogRepository;
        this.blogCategoryRepository = blogCategoryRepository;
        this.postTagRepository = postTagRepository;
    }

    /** 블로그 기본정보 요청 */
    @Override
    public BlogInfoDto BlogInfo(String nickname) {
        return blogRepository.blogInfo(nickname);
    }

    /** 블로그 설정정보 요청 */
    @Override
    public BlogConfigDto BlogConfig(Integer blogIndex) {
        ConfigInfoDto configInfoDto = blogRepository.configInfo(blogIndex);
        List<BlogCategoryEntity> blogCategoryEntities = blogCategoryRepository.findByBlogIndex(blogIndex);
        List<String> categoryList = new ArrayList<String>(blogCategoryEntities.stream().map(category -> category.getCategoryName()).toList());

        if(configInfoDto != null) {
            return BlogConfigDto.builder()
                    .name(configInfoDto.getName())
                    .skin(configInfoDto.getSkin())
                    .overview(configInfoDto.getOverview())
                    .categoryList(categoryList)
                    .build();
        }
        else return null;
    }

    /** 블로그 설정정보 저장 */
    @Override
    public void SaveConfig(BlogDto blogDto) {
        blogRepository.UpdateConfig(blogDto.getBlogIndex(), blogDto.getName(), blogDto.getSkin(), blogDto.getOverview());
    }

    @Override
    public List<String> TagList(Long blogIndex) {
        List<String> tagList = postTagRepository.BlogTagList(blogIndex);

        if(tagList != null) {
            return tagList;
        }
        else return null;
    }
}
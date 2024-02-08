package com.STC.StudyCode.Blog.Service;

import com.STC.StudyCode.Blog.Dto.*;
import com.STC.StudyCode.Entity.BlogCategoryEntity;
import com.STC.StudyCode.Entity.BlogEntity;
import com.STC.StudyCode.Repository.BlogCategoryRepository;
import com.STC.StudyCode.Repository.BlogRepository;
import com.STC.StudyCode.Repository.MemberRepository;
import com.STC.StudyCode.Repository.PostTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{

    BlogRepository blogRepository;
    BlogCategoryRepository blogCategoryRepository;
    PostTagRepository postTagRepository;
    MemberRepository memberRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository, BlogCategoryRepository blogCategoryRepository,
                           PostTagRepository postTagRepository, MemberRepository memberRepository) {
        this.blogRepository = blogRepository;
        this.blogCategoryRepository = blogCategoryRepository;
        this.postTagRepository = postTagRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public CheckBlogDto CheckBlog(AccessBlogDto accessBlogDto) {
        Long blogIndex = memberRepository.AccessBlog(accessBlogDto.getNickname());

        if(blogIndex != null) {
             Optional<BlogEntity> blogEntity = blogRepository.findById(blogIndex);
             if(blogEntity.get().getMemId().equals(accessBlogDto.getMemId())) {
                 return CheckBlogDto.builder()
                         .blogIndex(blogIndex)
                         .self(true)
                         .build();
             }
             else return CheckBlogDto.builder()
                     .blogIndex(blogIndex)
                     .self(false)
                     .build();
        }
        else {
            String memId = memberRepository.getMemId(accessBlogDto.getNickname());
            if(memId != null) {
                if(memId.equals(accessBlogDto.getMemId())) {
                    return CheckBlogDto.builder()
                            .self(true)
                            .build();
                }
                else return null;
            }
            else return null;
        }
    }

    /** 블로그 기본정보 요청 */
    @Override
    public BlogInfoDto BlogInfo(Long blogIndex) {
        return blogRepository.blogInfo(blogIndex);
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

    @Override
    @Transactional
    public void RegistOverView(OverViewDataDto overViewDataDto) {
        Optional<BlogEntity> blogEntity = blogRepository.findByMemId(overViewDataDto.getMemId());

        blogEntity.get().setOverview(overViewDataDto.getOverView());
    }
}
package com.STC.StudyCode.Service.Impl;

import com.STC.StudyCode.Blog.Dto.BlogDto;
import com.STC.StudyCode.Entity.BlogEntity;
import com.STC.StudyCode.Repository.BlogRepository;
import com.STC.StudyCode.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    BlogRepository blogRepository;
    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public BlogDto BlogInfo(String nickname) {
        Optional<BlogEntity> blogEntity = blogRepository.GetBlogInfo(nickname);

        if(blogEntity.isPresent()) {
            return blogEntity.get().toDto();
        }
        else return null;
    }
}

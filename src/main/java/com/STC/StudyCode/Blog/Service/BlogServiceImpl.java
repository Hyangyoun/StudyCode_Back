package com.STC.StudyCode.Blog.Service;

import com.STC.StudyCode.Blog.Dto.BlogConfigDto;
import com.STC.StudyCode.Blog.Dto.BlogDto;
import com.STC.StudyCode.Entity.BlogEntity;
import com.STC.StudyCode.Repository.BlogRepository;
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
}

package com.STC.StudyCode.Service.ServiceImpl;

import com.STC.StudyCode.Dto.BlogDto;
import com.STC.StudyCode.Dto.OverviewDto;
import com.STC.StudyCode.Dto.PostDto;
import com.STC.StudyCode.Entity.BlogEntity;
import com.STC.StudyCode.Entity.OverviewEntity;
import com.STC.StudyCode.Entity.PostEntity;
import com.STC.StudyCode.Repository.BlogRepository;
import com.STC.StudyCode.Repository.OverviewRepository;
import com.STC.StudyCode.Repository.PostRepository;
import com.STC.StudyCode.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    BlogRepository blogRepository;
    OverviewRepository overviewRepository;
    PostRepository postRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository, OverviewRepository overviewRepository, PostRepository postRepository) {
        this.blogRepository = blogRepository;
        this.overviewRepository = overviewRepository;
        this.postRepository = postRepository;
    }

    @Override
    public BlogDto GetBlogInfo(String memId) {
        Optional<BlogEntity> blogEntity = blogRepository.findById(memId);

        if(blogEntity.isPresent()) {
            return blogEntity.get().toDto();
        }
        else return null;
    }

    @Override
    public List<PostDto> PostList(String memId) {
        List<PostEntity> postEntities = postRepository.findAllByMemId(memId);
        List<PostDto> postDtos = new ArrayList<>();

        for(PostEntity postEntity : postEntities) {
            postDtos.add(postEntity.toDto());
        }

        return postDtos;
    }

    @Override
    public String RegistOverview(OverviewDto overviewDto) {
        OverviewEntity overviewEntity = overviewDto.toEntity();

        return overviewRepository.save(overviewEntity).getMemId();
    }
}

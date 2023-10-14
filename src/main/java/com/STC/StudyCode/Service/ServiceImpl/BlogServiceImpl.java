package com.STC.StudyCode.Service.ServiceImpl;

import com.STC.StudyCode.Dto.OverviewDto;
import com.STC.StudyCode.Entity.OverviewEntity;
import com.STC.StudyCode.Repository.BlogRepository;
import com.STC.StudyCode.Repository.OverviewRepository;
import com.STC.StudyCode.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    BlogRepository blogRepository;
    OverviewRepository overviewRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository, OverviewRepository overviewRepository) {
        this.blogRepository = blogRepository;
        this.overviewRepository = overviewRepository;
    }

    @Override
    public int RegistOverview(OverviewDto overviewDto) {
        OverviewEntity overviewEntity = overviewDto.toEntity();

        return overviewRepository.save(overviewEntity).getBlogIndex();
    }
}

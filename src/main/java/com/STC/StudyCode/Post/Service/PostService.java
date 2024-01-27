package com.STC.StudyCode.Post.Service;

import com.STC.StudyCode.Entity.PostEntity;
import com.STC.StudyCode.Post.Dto.PostToTagDto;

import java.util.List;

public interface PostService {
    List<PostToTagDto> PostInfo(Integer postIndex);

    PostEntity test(Long index);
}

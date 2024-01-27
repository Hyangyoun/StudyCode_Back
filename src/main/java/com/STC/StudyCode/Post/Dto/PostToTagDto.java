package com.STC.StudyCode.Post.Dto;

import com.STC.StudyCode.Entity.PostEntity;
import com.STC.StudyCode.Entity.PostTagEntity;

import java.util.List;

public interface PostToTagDto {
    PostEntity getPost();
    List<PostTagEntity> getTag();
}

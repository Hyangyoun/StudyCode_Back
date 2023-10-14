package com.STC.StudyCode.Service;

import com.STC.StudyCode.Dto.OverviewDto;

public interface BlogService {
    /** 소개글(Overview) 등록 */
    public int RegistOverview(OverviewDto overviewDto);
}

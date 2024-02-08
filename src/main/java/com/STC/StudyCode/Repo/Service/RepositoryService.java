package com.STC.StudyCode.Repo.Service;

import com.STC.StudyCode.Repo.Dto.RepoFileDto;
import com.STC.StudyCode.Repo.Dto.RepoFolderDto;

import java.util.List;

public interface RepositoryService {
    List<RepoFolderDto> FolderList(Long blogIndex);
    List<RepoFileDto> FileList(Long blogIndex, Long fileIndex);
    List<RepoFileDto> NoFolderFileList(Long blogIndex);
    void CreateFolder(Long blogIndex, String folderName);
}

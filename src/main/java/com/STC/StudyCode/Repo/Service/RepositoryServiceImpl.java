package com.STC.StudyCode.Repo.Service;

import com.STC.StudyCode.Entity.RepositoryEntity;
import com.STC.StudyCode.Entity.RepositoryType;
import com.STC.StudyCode.Repo.Dto.RepoFileDto;
import com.STC.StudyCode.Repo.Dto.RepoFolderDto;
import com.STC.StudyCode.Repository.RepoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepositoryServiceImpl implements RepositoryService{
    RepoRepository repoRepository;

    @Autowired
    public RepositoryServiceImpl(RepoRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    @Override
    public List<RepoFolderDto> FolderList(Long blogIndex) {
        List<RepoFolderDto> repoFolderDtos = repoRepository.FolderList(blogIndex, RepositoryType.F);

        if(repoFolderDtos != null) {
            return repoFolderDtos;
        }
        else return null;
    }

    @Override
    public List<RepoFileDto> FileList(Long blogIndex, Long fileIndex) {
        List<RepoFileDto> repoFileDtos = repoRepository.FileList(blogIndex, fileIndex, RepositoryType.D);

        if(repoFileDtos != null) {
            return repoFileDtos;
        }
        else return null;
    }

    @Override
    public List<RepoFileDto> NoFolderFileList(Long blogIndex) {
        List<RepoFileDto> repoFileDtos = repoRepository.FileList(blogIndex, RepositoryType.D);

        if(repoFileDtos != null) {
            return repoFileDtos;
        }
        else return null;
    }

    @Override
    public void CreateFolder(Long blogIndex, String folderName) {
        repoRepository.save(RepositoryEntity.builder()
                .fileName(folderName)
                .blogIndex(blogIndex)
                .type(RepositoryType.F)
                .build());
    }
}

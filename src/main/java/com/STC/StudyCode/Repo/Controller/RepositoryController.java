package com.STC.StudyCode.Repo.Controller;

import com.STC.StudyCode.Repo.Dto.RepoFileDto;
import com.STC.StudyCode.Repo.Dto.RepoFolderDto;
import com.STC.StudyCode.Repo.Service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/repository")
public class RepositoryController {
    RepositoryService repositoryService;

    @Autowired
    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping("/folder/list")
    public List<RepoFolderDto> FolderList(@RequestParam Long blogIndex) {
        return repositoryService.FolderList(blogIndex);
    }

    @GetMapping("/nofolder/list")
    public List<RepoFileDto> NoFolderFileList(@RequestParam Long blogIndex) {
        return repositoryService.NoFolderFileList(blogIndex);
    }

    @GetMapping("/file/list")
    public List<RepoFileDto> FileList(@RequestParam Long blogIndex, @RequestParam Long fileIndex) {
        return repositoryService.FileList(blogIndex, fileIndex);
    }

    @GetMapping("/add/folder")
    public void CreateFolder(@RequestParam Long blogIndex, @RequestParam String folderName) {
        repositoryService.CreateFolder(blogIndex, folderName);
    }
}

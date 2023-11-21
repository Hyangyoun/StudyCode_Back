package com.STC.StudyCode.Service.ServiceImpl;

import com.STC.StudyCode.Dto.*;
import com.STC.StudyCode.Entity.*;
import com.STC.StudyCode.Entity.Id.RepFolder;
import com.STC.StudyCode.Entity.Id.Repository;
import com.STC.StudyCode.Repository.*;
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
    RepFolderRepository repFolderRepository;
    RepoRepository repoRepository;
    PostTagRepository postTagRepository;
    PostCommentRepository postCommentRepository;
    PostReplyRepository postReplyRepository;
    MemberRepository memberRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository, OverviewRepository overviewRepository,
                           PostRepository postRepository, RepFolderRepository repFolderRepository,
                           RepoRepository repoRepository, PostTagRepository postTagRepository,
                           PostCommentRepository postCommentRepository, PostReplyRepository postReplyRepository,
                           MemberRepository memberRepository) {
        this.blogRepository = blogRepository;
        this.overviewRepository = overviewRepository;
        this.postRepository = postRepository;
        this.repFolderRepository = repFolderRepository;
        this.repoRepository = repoRepository;
        this.postTagRepository = postTagRepository;
        this.postCommentRepository = postCommentRepository;
        this.postReplyRepository = postReplyRepository;
        this.memberRepository = memberRepository;
    }

    /** 블로그 정보 요청 */
    @Override
    public BlogDto GetBlogInfo(String nickName) {
        String memId = memberRepository.getMemId(nickName);

        if(memId != null) {
            Optional<BlogEntity> blogEntity = blogRepository.findById(memId);

            if(blogEntity.isPresent()) {
                return blogEntity.get().toDto();
            }
            else return null;
        }
        else return null;
    }

    /** 블로그 포스트 목록 요청 */
    @Override
    public List<PostListDto> PostList(String memId) {
        List<PostListDto> postDtos = postRepository.findPostList(memId);

        if(postDtos != null) {
            return postDtos;
        }
        else return null;
    }

    /** 포스트 정보 요청 */
    @Override
    public PostInfoDto PostInfo(int postIndex) {
        PostInfoDto postInfoDto = postRepository.findPostInfo(postIndex);
        if(postInfoDto != null) {
            return postInfoDto;
        }
        else return null;
    }

    /** 포스트 태그 리스트 요청 */
    @Override
    public List<PostTagListDto> PostTagList(int postIndex) {
        List<PostTagListDto> postTagListDtos = postTagRepository.getTagName(postIndex);

        if(postTagListDtos != null) {
            return postTagListDtos;
        }
        else return null;
    }

    @Override
    public List<PostRepoDto> PostRepoList(int postIndex) {
        List<PostRepoDto> postRepoDtos = repoRepository.findFile(postIndex);

        if(postRepoDtos != null) {
            return postRepoDtos;
        }
        else return null;
    }

    /** 소개글 등록 */
    @Override
    public String RegistOverview(OverviewDto overviewDto) {
        OverviewEntity overviewEntity = overviewDto.toEntity();

        return overviewRepository.save(overviewEntity).getMemId();
    }

    /** 소개글 조회 */
    @Override
    public OverviewDto GetOverview(String memId) {
        Optional<OverviewEntity> overviewEntity = overviewRepository.findById(memId);

        if(overviewEntity.isPresent()) {
            return overviewEntity.get().toDto();
        }
        else return null;
    }

    /** 레포지토리 폴더 등록 */
    @Override
    public String RegistRepo(RepFolderDto repFolderDto) {
        RepFolderEntity repFolderEntity = repFolderDto.toEntity();

        if(repFolderRepository.findById(new RepFolder(repFolderDto.getFolderName(), repFolderDto.getMemId())).isEmpty()) {
            return repFolderRepository.save(repFolderEntity).getFolderName();
        }
        else return "폴더이름이 중복됩니다.";
    }

    /** 레포지토리 파일목록 요청 */
    @Override
    public List<RepFolderDto> GetRepo(String memId) {
        List<RepFolderEntity> repFolderEntities = repFolderRepository.findAllByMemId(memId);
        List<RepFolderDto> repFolderDtos = new ArrayList<>();

        for(RepFolderEntity repFolderEntity : repFolderEntities) {
            repFolderDtos.add(repFolderEntity.toDto());
        }

        return repFolderDtos;
    }

    /** 레포지토리 파일 등록 */
    @Override
    public String RegistFile(RepositoryDto repositoryDto) {
        RepositoryEntity repositoryEntity = repositoryDto.toEntity();

        if(repoRepository.findById(new Repository(repositoryDto.getFileName(),repositoryDto.getFolderName(),repositoryDto.getMemId())).isEmpty()) {
            return repoRepository.save(repositoryEntity).getFileName();
        }
        else return "해당 폴더에 이미 등록되어있는 파일명입니다.";
    }

    /** 레포지토리 파일목록 요청 */
    @Override
    public List<RepositoryDto> GetFile(String memId) {
        List<RepositoryEntity> repositoryEntities = repoRepository.findAllByMemId(memId);
        List<RepositoryDto> repositoryDtos = new ArrayList<>();

        for(RepositoryEntity repositoryEntity : repositoryEntities) {
            repositoryDtos.add(repositoryEntity.toDto());
        }

        return repositoryDtos;
    }

    /** 포스트 댓글 리스트 요청 */
    @Override
    public List<Object> GetComment(Integer postIndex) {
        List<PostCommentEntity> postCommentEntities = postCommentRepository.findAllByPostIndex(postIndex);
        List<PostCommentDto> postCommentDtos = new ArrayList<>();
        List<PostReplyEntity> postReplyEntities = postReplyRepository.findAllByPostIndex(postIndex);
        List<PostReplyDto> postReplyDtos = new ArrayList<>();

        for(PostCommentEntity postCommentEntity : postCommentEntities) {
            postCommentDtos.add(postCommentEntity.toDto());
        }

        for(PostReplyEntity postReplyEntity : postReplyEntities) {
            postReplyDtos.add(postReplyEntity.toDto());
        }

        List<Object> commentList = new ArrayList<>();
        commentList.add(postCommentDtos);
        commentList.add(postReplyDtos);

        return commentList;
    }
}

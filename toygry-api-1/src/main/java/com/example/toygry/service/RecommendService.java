package com.example.toygry.service;

import com.example.toygry.dto.AddRecommendRequest;
import com.example.toygry.dto.CheckPasswordRecommendRequest;
import com.example.toygry.dto.RecommendResponse;
import com.example.toygry.dto.UpdateRecommendRequest;
import com.example.toygry.entity.Recommend;
import com.example.toygry.exception.InvalidPasswordException;
import com.example.toygry.exception.InvalidUserException;
import com.example.toygry.exception.RecommendNotFoundException;
import com.example.toygry.mapper.RecommendMapper;
import com.example.toygry.repository.RecommendRepository;
import com.example.toygry.utils.KeycloakToken;
import com.example.toygry.utils.TokenUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RecommendService {

    private final RecommendRepository recommendRepository;

    public RecommendService(RecommendRepository recommendRepository) {
        this.recommendRepository = recommendRepository;
    }

    /**
     * 전체 게시글 목록 출력
     *
     * @return 전체 게시글 목록
     */
    public List<RecommendResponse> getAll() {
        List<RecommendResponse> result = new ArrayList<>();

        List<Recommend> recommend=recommendRepository.findAll();
        for (Recommend item : recommend) {
            result.add(RecommendResponse.builder()
                    .id(item.getId())
                    .userId(item.getUserId())
                    .password(item.getPassword())
                    .recommendType(item.getRecommendType())
                    .title(item.getTitle())
                    .contents(item.getContents())
                    .image(item.getImage())
                    .createdDate(item.getCreatedDate())
                    .modifiedDate(item.getModifiedDate())
                    .build());
        }

        return result;
    }

    /**
     * id 에 해당하는 게시글 조회
     *
     * @param id 게시글의 id
     * @return id 에 해당하는 게시글
     */
    public RecommendResponse getRecommend(String id) {
        Recommend recommend = recommendRepository.findById(id)
                .orElseThrow(() -> new RecommendNotFoundException("ERROR: Cannot found id"));
        return RecommendMapper.toDto(recommend);
    }

    /**
     * 신규 게시글 (Recommend) 추가
     *
     * @param token 로그인 정보 token 값 (유저정보)
     * @param request 추가하고자 하는 정보
     * @return 신규 추가된 값
     */
    public RecommendResponse addRecommend(String token, AddRecommendRequest request) {
        // token parsing
        TokenUtils tokenUtils = new TokenUtils();
        KeycloakToken keycloakToken = tokenUtils.tokenParser(token);

        Recommend recommend = Recommend.builder()
                .userId(keycloakToken.userId())
                .password(request.getPassword())
                .recommendType(request.getRecommendType())
                .title(request.getTitle())
                .contents(request.getContents())
                .image(request.getImage())
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        Recommend result = recommendRepository.save(recommend);

        return RecommendMapper.toDto(result);
    }

    /**
     * 게시글 update
     *
     * @param id 게시글 아이디
     * @return update 정보
     */
    public RecommendResponse updateRecommend(String id, UpdateRecommendRequest request) {

        Recommend recommend = recommendRepository.findById(id)
                .orElseThrow(() -> new RecommendNotFoundException("ERROR: Cannot found id"));
        recommend.update(request);
        Recommend result = recommendRepository.save(recommend);
        return RecommendMapper.toDto(result);
    }

    /**
     * 게시글 삭제
     *
     * @param request 게시글 id, 게시글 password
     * @return delete 게시글 id
     */
    public String deleteRecommend(CheckPasswordRecommendRequest request) {
        Recommend recommend = recommendRepository.findById(request.getId())
                .orElseThrow(() -> new RecommendNotFoundException("ERROR: Cannot found id"));
        if (!Objects.equals(recommend.getPassword(), request.getPassword())) {
            throw new InvalidPasswordException("ERROR: Please Check password");
        }
        recommendRepository.delete(recommend);

        return request.getId();
    }

    /**
     * 게시글에 대한 user 정보와 password 정보 확인하기
     *
     * @param token 로그인 정보
     * @param request 게시글 id , password
     * @return 정상적인 접근 시 true 이외에 exception
     */
    public RecommendResponse checkInformation(String token, CheckPasswordRecommendRequest request) {
        TokenUtils tokenUtils = new TokenUtils();
        KeycloakToken keycloakToken = tokenUtils.tokenParser(token);

        Recommend recommend = recommendRepository.findById(request.getId())
                .orElseThrow(() -> new RecommendNotFoundException("ERROR: Cannot found id"));

        RecommendResponse recommendResponse = RecommendMapper.toDto(recommend);

        if (!Objects.equals(keycloakToken.userId(), recommend.getUserId())) {
            throw new InvalidUserException("ERROR: Invalid user");
        }
        else if (!Objects.equals(recommend.getPassword(), request.getPassword())) {
            throw new InvalidPasswordException("ERROR: Please Check password");
        } else {
            return recommendResponse;
        }
    }

    /**
     * 게시글 정보와 user 정보가 동일한지 확인하는 메소드
     *
     * @param recommend 게시글 정보
     * @param userId user 정보
     */
    private void checkUserInfo(Recommend recommend, String userId) {
        if (!Objects.equals(recommend.getUserId(), userId)) {
            throw new InvalidUserException("ERROR: Please Check User info");
        }
    }
}

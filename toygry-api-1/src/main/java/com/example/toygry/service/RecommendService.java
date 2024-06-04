package com.example.toygry.service;

import com.example.toygry.dto.AddRecommendRequest;
import com.example.toygry.dto.RecommendResponse;
import com.example.toygry.entity.Recommend;
import com.example.toygry.entity.RecommendType;
import com.example.toygry.mapper.RecommendMapper;
import com.example.toygry.repository.RecommendRepository;
import com.example.toygry.utils.KeycloakToken;
import com.example.toygry.utils.TokenUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        Recommend recommend = recommendRepository.findById(id);
        return RecommendMapper.toDto(recommend);
    }

    /**
     * 신규 게시글 (Recommend) 추가
     // TODO : keycloak 고쳐지면 userId 추가하기
     *
     * @param token 로그인 정보 token 값 (유저정보)
     * @param request 추가하고자 하는 정보
     * @return 신규 추가된 값
     */
    public RecommendResponse addRecommend(AddRecommendRequest request) {
        // token parsing
//        TokenUtils tokenUtils = new TokenUtils();
//        KeycloakToken keycloakToken = tokenUtils.tokenParser(token);

        Recommend recommend = Recommend.builder()
                .userId(request.getUserId())
//                .userId(keycloakToken.userId())
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
}

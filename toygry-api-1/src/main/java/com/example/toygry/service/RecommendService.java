package com.example.toygry.service;

import com.example.toygry.dto.RecommendResponse;
import com.example.toygry.entity.Recommend;
import com.example.toygry.mapper.RecommendMapper;
import com.example.toygry.repository.RecommendRepository;
import org.springframework.stereotype.Service;

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
}

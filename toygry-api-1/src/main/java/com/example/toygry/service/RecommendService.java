package com.example.toygry.service;

import com.example.toygry.entity.Recommend;
import com.example.toygry.repository.RecommendRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendService {

    private final RecommendRepository recommendRepository;

    public RecommendService(RecommendRepository recommendRepository) {
        this.recommendRepository = recommendRepository;
    }

    public String getAll() {
        List<Recommend> recommend=recommendRepository.findAll();
        return recommend.toString();
    }
}

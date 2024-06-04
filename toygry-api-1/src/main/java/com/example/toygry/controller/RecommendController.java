package com.example.toygry.controller;

import com.example.toygry.dto.AddRecommendRequest;
import com.example.toygry.dto.RecommendResponse;
import com.example.toygry.service.RecommendService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// controller 는 return 값이 String 일때 뷰(html) 문서가 랜더링 됨
@RestController // Http 메세지 바디에 바로 압력된다
@RequestMapping("/recommend")
public class RecommendController {

    private final RecommendService recommendService;

    public RecommendController(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    @GetMapping("/list")
    public List<RecommendResponse> getAll() {
        return recommendService.getAll();
    }

    @GetMapping("/{id}")
    public RecommendResponse getRecommend(@PathVariable String id) {
        return recommendService.getRecommend(id);
    }

    @PostMapping
    public RecommendResponse addRecommend(
//            @RequestHeader("Authorization") String token,
            @RequestBody AddRecommendRequest request) {
        return recommendService.addRecommend(request);
    }

    @PatchMapping("/{id}")
    public String updateRecommend(@PathVariable String id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteRecommend(@PathVariable String id) {
        return null;
    }
}

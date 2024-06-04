package com.example.toygry.repository;

import com.example.toygry.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendRepository extends JpaRepository<Recommend, Integer> {
    Recommend findById(String id);
}

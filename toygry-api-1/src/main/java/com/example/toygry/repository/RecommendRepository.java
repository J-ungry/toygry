package com.example.toygry.repository;

import com.example.toygry.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecommendRepository extends JpaRepository<Recommend, Integer> {
    Optional<Recommend> findById(String id);
}

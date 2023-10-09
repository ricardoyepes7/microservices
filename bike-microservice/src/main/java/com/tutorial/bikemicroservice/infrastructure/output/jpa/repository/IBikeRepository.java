package com.tutorial.bikemicroservice.infrastructure.output.jpa.repository;

import com.tutorial.bikemicroservice.infrastructure.output.jpa.entity.BikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBikeRepository extends JpaRepository<BikeEntity,Long> {
    List<BikeEntity> findByUserId(long userId);
}

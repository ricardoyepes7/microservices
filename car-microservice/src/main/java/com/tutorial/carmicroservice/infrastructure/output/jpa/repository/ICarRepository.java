package com.tutorial.carmicroservice.infrastructure.output.jpa.repository;

import com.tutorial.carmicroservice.infrastructure.output.jpa.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends JpaRepository<CarEntity,Long> {
    List<CarEntity> findByUserId(long userId);
}

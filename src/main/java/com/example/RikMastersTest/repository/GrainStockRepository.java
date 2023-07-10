package com.example.RikMastersTest.repository;

import com.example.RikMastersTest.model.GrainStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GrainStockRepository extends JpaRepository<GrainStock, Long> {
    Optional<GrainStock> findByGrainTypeAndOriginCountry(String grainType, String originCountry);

    List<GrainStock> findByGrainType(String grainType);

    List<GrainStock> findByOriginCountry(String originCountry);
}

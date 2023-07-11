package com.example.RikMastersTest.repository;


import com.example.RikMastersTest.model.GrainRoasting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrainRoastingRepository extends JpaRepository<GrainRoasting, Long> {
}
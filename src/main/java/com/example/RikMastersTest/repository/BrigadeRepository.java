package com.example.RikMastersTest.repository;



import com.example.RikMastersTest.model.Brigade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BrigadeRepository extends JpaRepository<Brigade, UUID> {
}
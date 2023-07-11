package com.example.RikMastersTest.service;


import com.example.RikMastersTest.model.GrainRoasting;
import com.example.RikMastersTest.repository.GrainRoastingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrainRoastingService {
    private final GrainRoastingRepository grainRoastingRepository;

    @Autowired
    public GrainRoastingService(GrainRoastingRepository grainRoastingRepository) {
        this.grainRoastingRepository = grainRoastingRepository;
    }

    public void save(GrainRoasting grainRoasting) {
        grainRoastingRepository.save(grainRoasting);
    }

    public List<GrainRoasting> grainRoastingsInOrderOfLossPercentage() {
        return grainRoastingRepository.findAll()
                .stream()
                .sorted(Comparator.comparingDouble(GrainRoasting::getLossPercentage))
                .collect(Collectors.toList());
    }
}
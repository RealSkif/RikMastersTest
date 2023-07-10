package com.example.RikMastersTest.service;


import com.example.RikMastersTest.model.GrainStock;
import com.example.RikMastersTest.repository.GrainStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class GrainStockService {
    private final GrainStockRepository grainStockRepository;

    @Autowired
    public GrainStockService(GrainStockRepository grainStockRepository) {
        this.grainStockRepository = grainStockRepository;
    }

    public List<GrainStock> findByGrainType(String grainType) {
        return grainStockRepository.findByGrainType(grainType)
                .stream()
                .sorted(Comparator.comparingDouble(GrainStock::getQuantity))
                .collect(Collectors.toList());
    }

    public List<GrainStock> findByOriginCountry(String originCountry) {
        return grainStockRepository.findByGrainType(originCountry)
                .stream()
                .sorted(Comparator.comparingDouble(GrainStock::getQuantity))
                .collect(Collectors.toList());
    }
}

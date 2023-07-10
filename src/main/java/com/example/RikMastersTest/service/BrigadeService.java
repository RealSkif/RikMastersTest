package com.example.RikMastersTest.service;


import com.example.RikMastersTest.model.Brigade;
import com.example.RikMastersTest.repository.BrigadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrigadeService {
    private final BrigadeRepository brigadeRepository;

    @Autowired
    public BrigadeService(BrigadeRepository brigadeRepository) {
        this.brigadeRepository = brigadeRepository;
    }

    public List<Brigade> brigadesInOrderOfLossPercentage() {
        return brigadeRepository.findAll()
                .stream()
                .sorted(Comparator.comparingDouble(Brigade::getLossPercentage))
                .collect(Collectors.toList());
    }
}
//    public List<Brigade> brigadesInOrderOfLossPercentage(){
//        return brigadeRepository.findAll()
//                .stream()
//                .sorted(Comparator.comparingDouble(Brigade::getLossPercentage))
//                .collect(Collectors.toList());}
//}
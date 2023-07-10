package com.example.RikMastersTest.service;

import com.example.RikMastersTest.kafka.GrainArrival;
import com.example.RikMastersTest.model.GrainStock;
import com.example.RikMastersTest.repository.GrainStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GrainArrivalListener {
    private final GrainStockRepository grainStockRepository;

    @Autowired
    public GrainArrivalListener(GrainStockRepository grainStockRepository) {
        this.grainStockRepository = grainStockRepository;
    }

    @KafkaListener(topics = "grain-arrival-topic", groupId = "grain-arrival-consumer-group")
    public void listenGrainArrival(GrainStock grainStock) {

            Optional <GrainStock> find = grainStockRepository.findByGrainTypeAndOriginCountry(grainStock.getGrainType(),
                    grainStock.getOriginCountry());
            if(find.isPresent()) {
                GrainStock foundGrainStock = find.get();
            foundGrainStock.setQuantity(foundGrainStock.getQuantity() + grainStock.getQuantity());
            grainStockRepository.save(foundGrainStock);
        }
    }
}

package com.example.RikMastersTest.kafka;

import com.example.RikMastersTest.model.GrainStock;
import com.example.RikMastersTest.repository.GrainStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenGrainArrival(GrainStock grainStock) {

        Optional<GrainStock> find = grainStockRepository.findByGrainTypeAndOriginCountry(grainStock.getGrainType(),
                grainStock.getOriginCountry());
        if (find.isPresent()) {
            GrainStock foundGrainStock = find.get();
            foundGrainStock.setQuantity(foundGrainStock.getQuantity() + grainStock.getQuantity());
            grainStockRepository.save(foundGrainStock);
        }
    }
}

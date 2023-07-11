package com.example.RikMastersTest.controller;


import com.example.RikMastersTest.model.GrainRoasting;
import com.example.RikMastersTest.service.GrainRoastingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grainRoasting")
public class GrainRoastingController {
    private final GrainRoastingService grainRoastingService;

    @Autowired
    public GrainRoastingController(GrainRoastingService grainRoastingService) {
        this.grainRoastingService = grainRoastingService;
    }

    @GetMapping()
    public List<GrainRoasting> getGrainRoastingLossPercentage() {
        return grainRoastingService.grainRoastingsInOrderOfLossPercentage();
    }
}
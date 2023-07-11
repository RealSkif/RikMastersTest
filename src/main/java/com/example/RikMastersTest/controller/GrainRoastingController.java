package com.example.RikMastersTest.controller;


import com.example.RikMastersTest.model.GrainRoasting;
import com.example.RikMastersTest.service.GrainRoastingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grainRoasting")
@Api(tags = "GrainRoasting API")
public class GrainRoastingController {
    private final GrainRoastingService grainRoastingService;

    @Autowired
    public GrainRoastingController(GrainRoastingService grainRoastingService) {
        this.grainRoastingService = grainRoastingService;
    }

    @GetMapping()
    @ApiOperation("Get grain roasting in order of loss percentage")
    public List<GrainRoasting> getGrainRoastingLossPercentage() {
        return grainRoastingService.grainRoastingsInOrderOfLossPercentage();
    }
}
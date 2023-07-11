package com.example.RikMastersTest.controller;


import com.example.RikMastersTest.model.GrainStock;
import com.example.RikMastersTest.service.GrainStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/grainStocks")
public class GrainStockController {
    private final GrainStockService grainStockService;

    @Autowired
    public GrainStockController(GrainStockService grainStockService) {
        this.grainStockService = grainStockService;
    }

    @GetMapping(params = "grainType")
    public List<GrainStock> getStocksByGrainType(@RequestParam(required = false) String grainType) {
        return grainStockService.findByGrainType(grainType);
    }
    @GetMapping(params = "originCountry")
    public List<GrainStock> getStocksByOriginCountry(@RequestParam(required = false) String originCountry) {
        return grainStockService.findByOriginCountry(originCountry);
    }
}
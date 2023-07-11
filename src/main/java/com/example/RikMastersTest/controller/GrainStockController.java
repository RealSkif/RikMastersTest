package com.example.RikMastersTest.controller;


import com.example.RikMastersTest.model.GrainStock;
import com.example.RikMastersTest.service.GrainStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/grainStocks")
@Api(tags = "Grain Stocks API")
public class GrainStockController {
    private final GrainStockService grainStockService;

    @Autowired
    public GrainStockController(GrainStockService grainStockService) {
        this.grainStockService = grainStockService;
    }

    @GetMapping(params = "grainType")
    @ApiOperation("Get grain stock of requested grain type")
    public List<GrainStock> getStocksByGrainType(@RequestParam(required = false) String grainType) {
        return grainStockService.findByGrainType(grainType);
    }

    @GetMapping(params = "originCountry")
    @ApiOperation("Get grain stock of requested origin country")
    public List<GrainStock> getStocksByOriginCountry(@RequestParam(required = false) String originCountry) {
        return grainStockService.findByOriginCountry(originCountry);
    }
}
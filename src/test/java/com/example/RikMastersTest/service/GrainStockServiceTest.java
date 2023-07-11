package com.example.RikMastersTest.service;

import com.example.RikMastersTest.model.GrainStock;
import com.example.RikMastersTest.repository.GrainStockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GrainStockServiceTest {

    @InjectMocks
    private GrainStockService grainStockService;

    @Mock
    private GrainStockRepository grainStockRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByGrainType() {
        GrainStock grainStock1 = new GrainStock();
        grainStock1.setGrainType("Wheat");
        grainStock1.setQuantity(100);

        GrainStock grainStock2 = new GrainStock();
        grainStock2.setGrainType("Rice");
        grainStock2.setQuantity(200);

        List<GrainStock> grainStockList = Arrays.asList(grainStock1, grainStock2);

        when(grainStockRepository.findByGrainType("Wheat")).thenReturn(grainStockList);

        List<GrainStock> result = grainStockService.findByGrainType("Wheat");

        assertEquals(grainStock1, result.get(0));
        assertEquals(grainStock2, result.get(1));
    }

    @Test
    public void testFindByOriginCountry() {
        GrainStock grainStock1 = new GrainStock();
        grainStock1.setOriginCountry("Country1");
        grainStock1.setQuantity(100);

        GrainStock grainStock2 = new GrainStock();
        grainStock2.setOriginCountry("Country2");
        grainStock2.setQuantity(200);

        List<GrainStock> grainStockList = Arrays.asList(grainStock1, grainStock2);

        when(grainStockRepository.findByGrainType("Country1")).thenReturn(grainStockList);

        List<GrainStock> result = grainStockService.findByOriginCountry("Country1");

        assertEquals(grainStock1, result.get(0));
        assertEquals(grainStock2, result.get(1));
    }
}

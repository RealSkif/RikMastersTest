package com.example.RikMastersTest.service;

import com.example.RikMastersTest.model.GrainRoasting;
import com.example.RikMastersTest.repository.GrainRoastingRepository;
import com.example.RikMastersTest.service.GrainRoastingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GrainRoastingServiceTest {

    @InjectMocks
    private GrainRoastingService grainRoastingService;
    @Mock
    private GrainRoastingRepository grainRoastingRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        GrainRoasting grainRoasting = new GrainRoasting();
        grainRoasting.setOriginCountry("Country");
        grainRoasting.setQuantity(100);
        grainRoasting.setLossPercentage(5.0);

        grainRoastingService.save(grainRoasting);

        verify(grainRoastingRepository).save(grainRoasting);
    }

    @Test
    public void testGrainRoastingsInOrderOfLossPercentage() {
        GrainRoasting grainRoasting1 = new GrainRoasting();
        grainRoasting1.setOriginCountry("Country1");
        grainRoasting1.setQuantity(100);
        grainRoasting1.setLossPercentage(5.0);

        GrainRoasting grainRoasting2 = new GrainRoasting();
        grainRoasting2.setOriginCountry("Country2");
        grainRoasting2.setQuantity(200);
        grainRoasting2.setLossPercentage(2.5);

        List<GrainRoasting> unsortedList = Arrays.asList(grainRoasting2, grainRoasting1);

        when(grainRoastingRepository.findAll()).thenReturn(unsortedList);

        List<GrainRoasting> sortedList = grainRoastingService.grainRoastingsInOrderOfLossPercentage();

        assertEquals(grainRoasting2, sortedList.get(0));
        assertEquals(grainRoasting1, sortedList.get(1));
    }
}

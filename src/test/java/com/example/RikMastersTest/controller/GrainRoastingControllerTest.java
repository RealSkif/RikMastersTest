package com.example.RikMastersTest.controller;

import com.example.RikMastersTest.controller.GrainRoastingController;
import com.example.RikMastersTest.model.GrainRoasting;
import com.example.RikMastersTest.service.GrainRoastingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WebMvcTest(GrainRoastingController.class)
public class GrainRoastingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GrainRoastingService grainRoastingService;

    @Test
    public void testGetGrainRoastingLossPercentage() throws Exception {
        GrainRoasting grainRoasting1 = new GrainRoasting();
        GrainRoasting grainRoasting2 = new GrainRoasting();
        List<GrainRoasting> grainRoastingList = Arrays.asList(grainRoasting1, grainRoasting2);
        Mockito.when(grainRoastingService.grainRoastingsInOrderOfLossPercentage()).thenReturn(grainRoastingList);

        mockMvc.perform(MockMvcRequestBuilders.get("/grainRoasting"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(grainRoasting1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].originCountry").value(grainRoasting1.getOriginCountry()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(grainRoasting2.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].originCountry").value(grainRoasting2.getOriginCountry()));
        verify(grainRoastingService, times(1)).grainRoastingsInOrderOfLossPercentage();
    }
}

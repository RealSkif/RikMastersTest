package com.example.RikMastersTest.controller;

import com.example.RikMastersTest.model.GrainStock;
import com.example.RikMastersTest.service.GrainStockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GrainStockController.class)

public class GrainStockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GrainStockService grainStockService;

    @Test
    public void testGetStocksByGrainType() throws Exception {
        String grainType = "Arabica";
        GrainStock stock1 = new GrainStock();
        stock1.setGrainType("Arabica");
        GrainStock stock2 = new GrainStock();
        stock2.setGrainType("Arabica");
        List<GrainStock> stocks = Arrays.asList(stock1, stock2);
        when(grainStockService.findByGrainType(grainType)).thenReturn(stocks);

        mockMvc.perform(get("/grainStocks?grainType=Arabica"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

        verify(grainStockService, times(1)).findByGrainType(grainType);
    }

    @Test
    public void testGetStocksByOriginCountry() throws Exception {
        String originCountry = "Brazil";
        GrainStock stock1 = new GrainStock();
        stock1.setOriginCountry("Brazil");
        GrainStock stock2 = new GrainStock();
        stock2.setOriginCountry("Brazil");
        List<GrainStock> stocks = Arrays.asList(stock1, stock2);
        when(grainStockService.findByOriginCountry(originCountry)).thenReturn(stocks);

        mockMvc.perform(get("/grainStocks?originCountry=Brazil"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

        verify(grainStockService, times(1)).findByOriginCountry(originCountry);
    }
}

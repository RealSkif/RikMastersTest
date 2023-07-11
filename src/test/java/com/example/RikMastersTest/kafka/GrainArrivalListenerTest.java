package com.example.RikMastersTest.kafka;

import com.example.RikMastersTest.model.GrainStock;
import com.example.RikMastersTest.repository.GrainStockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class GrainArrivalListenerTest {

    private GrainArrivalListener grainArrivalListener;

    @Mock
    private GrainStockRepository grainStockRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        grainArrivalListener = new GrainArrivalListener(grainStockRepository);
    }

    @Test
    public void testListenGrainArrival() {
        GrainStock grainStock = mock(GrainStock.class);
        when(grainStock.getGrainType()).thenReturn("Type");
        when(grainStock.getOriginCountry()).thenReturn("Country");
        when(grainStock.getQuantity()).thenReturn(100.0);

        GrainStock existingGrainStock = mock(GrainStock.class);
        when(existingGrainStock.getGrainType()).thenReturn("Type");
        when(existingGrainStock.getOriginCountry()).thenReturn("Country");
        when(existingGrainStock.getQuantity()).thenReturn(50.0);

        when(grainStockRepository.findByGrainTypeAndOriginCountry(anyString(), anyString()))
                .thenReturn(Optional.of(existingGrainStock));

        grainArrivalListener.listenGrainArrival(grainStock);

        verify(existingGrainStock).setQuantity(150.0);
        verify(grainStockRepository).save(existingGrainStock);
    }
}



package com.example.RikMastersTest.controller;


import com.example.RikMastersTest.service.BrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brigades")
public class BrigadeController {
    private final BrigadeService brigadeService;

    @Autowired
    public BrigadeController(BrigadeService brigadeService) {
        this.brigadeService = brigadeService;
    }

//    @GetMapping("/{brigadeNumber}/loss")
//    public double getBrigadeLossPercentage(@PathVariable int brigadeNumber) {
        // Получение процента потерь для указанной бригады
//        return brigadeService.getBrigadeLossPercentage(brigadeNumber);
//    }
}
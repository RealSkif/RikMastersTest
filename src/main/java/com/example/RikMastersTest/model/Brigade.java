//package com.example.RikMastersTest.model;
//
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "brigade")
//public class Brigade {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private UUID id;
//
//    @OneToMany(mappedBy = "owner")
//    private List<GrainRoasting> grainRoasting;
//
//    public void removeGrainRoasting(GrainRoasting grainRoasting){
//        this.grainRoasting.remove(grainRoasting);
//
//    }
//
//    public void addGrainRoasting(GrainRoasting grain){
//        if(this.grainRoasting == null) grainRoasting = new ArrayList<>();
//        this.grainRoasting.add(grain);
//    }
//}
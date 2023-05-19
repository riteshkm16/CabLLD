package io.riteshkm16.lld.cab.controller;

import io.riteshkm16.lld.cab.model.Cab;
import io.riteshkm16.lld.cab.model.Ride;
import io.riteshkm16.lld.cab.model.User;
import io.riteshkm16.lld.cab.service.CabService;

import java.util.List;

public class CabController {
    private CabService cabService;
    public CabController(CabService cabService){
        this.cabService = cabService;
    }
    //1.register cab
    public Cab registerCab(Cab cab){
        return cabService.registerCab(cab);
    }
}

package io.riteshkm16.lld.cab.service.impl;

import io.riteshkm16.lld.cab.config.AppConfig;
import io.riteshkm16.lld.cab.model.Cab;
import io.riteshkm16.lld.cab.model.dto.Location;
import io.riteshkm16.lld.cab.repository.CabRepository;
import io.riteshkm16.lld.cab.service.CabService;

import java.util.ArrayList;
import java.util.List;

public class CabServiceImpl implements CabService {

    private CabRepository cabRepository;
    public CabServiceImpl(CabRepository cabRepository){
        this.cabRepository = cabRepository;
    }

    @Override
    public Cab registerCab(Cab cab) {
        return cabRepository.save(cab);
    }

    @Override
    public Cab updateCab(Cab cab) {
        return cabRepository.update(cabRepository.update(cab));
    }

    @Override
    public List<Cab> availableCab(Location fromLocation, double distanceThreshold) {
        List<Cab> availableForBooking = new ArrayList<>();
        for(Cab cab : cabRepository.getAvailableCab()){
            if(Location.getDistance(cab.getLocation(),fromLocation) <= AppConfig.CONST_DISTANCE_THRESHOLD){
                availableForBooking.add(cab);
            }
        }
        return availableForBooking;
    }
}

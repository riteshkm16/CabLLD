package io.riteshkm16.lld.cab.service;

import io.riteshkm16.lld.cab.model.Cab;
import io.riteshkm16.lld.cab.model.dto.Location;

import java.util.List;

public interface CabService {
    Cab registerCab(Cab cab);
    Cab updateCab(Cab cab);
    List<Cab> availableCab(Location fromLocation,double distanceThreshold);
}

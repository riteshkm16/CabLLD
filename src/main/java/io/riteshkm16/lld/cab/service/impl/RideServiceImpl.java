package io.riteshkm16.lld.cab.service.impl;

import io.riteshkm16.lld.cab.Application;
import io.riteshkm16.lld.cab.config.AppConfig;
import io.riteshkm16.lld.cab.model.Cab;
import io.riteshkm16.lld.cab.model.Ride;
import io.riteshkm16.lld.cab.model.User;
import io.riteshkm16.lld.cab.model.dto.Location;
import io.riteshkm16.lld.cab.model.enums.Status;
import io.riteshkm16.lld.cab.repository.RideRepository;
import io.riteshkm16.lld.cab.service.CabService;
import io.riteshkm16.lld.cab.service.RideService;

import java.util.List;

public class RideServiceImpl implements RideService {

    private RideRepository rideRepository;
    private CabService cabService;

    public RideServiceImpl(RideRepository rideRepository,CabService cabService){
        this.cabService = cabService;
        this.rideRepository = rideRepository;
    }

    @Override
    public Ride bookRide(Location fromLocation, Location toLocation,User user) {
        List<Cab> availableCabs = cabService.availableCab(fromLocation, AppConfig.CONST_DISTANCE_THRESHOLD);

        if (availableCabs == null || availableCabs.size() == 0){
            return null;
        }

        //get first for now
        //todo
        Cab selectedCab = availableCabs.get(0);


        double distance = Location.getDistance(fromLocation,toLocation);
        Ride ride = Ride.builder()
                .userId(user.getId())
                .cabId(selectedCab.getId())
                .fromLocation(fromLocation)
                .toLocation(toLocation)
                .distance(distance)
                .fare(distance*AppConfig.CONST_FARE_PER_KM + AppConfig.CONST_FIXED_FARE)
                .status(Status.SCHEDULED)
                .build();

        selectedCab.setAvailable(false);
        cabService.registerCab(selectedCab);

        Ride savedRide = rideRepository.save(ride);

        return savedRide;
    }

    @Override
    public Ride startRide(Ride ride) {
        return null;
    }

    @Override
    public Ride endRide(Ride ride) {
        return null;
    }

    @Override
    public List<Ride> getMyRide(User user) {
        return null;
    }
}

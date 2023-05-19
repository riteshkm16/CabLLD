package io.riteshkm16.lld.cab.controller;

import io.riteshkm16.lld.cab.model.Cab;
import io.riteshkm16.lld.cab.model.Ride;
import io.riteshkm16.lld.cab.model.User;
import io.riteshkm16.lld.cab.model.dto.Location;
import io.riteshkm16.lld.cab.service.CabService;
import io.riteshkm16.lld.cab.service.RideService;

import java.util.List;

public class RideController {

    private RideService rideService;
    public RideController(RideService rideService){
        this.rideService = rideService;
    }

    //1.Book a ride
    public Ride bookRide(Location fromLocation, Location toLocation,User user){
        return rideService.bookRide(fromLocation,toLocation,user);
    }

    //2.start Ride
    public Ride startRide(Ride ride){
        return null;
    }

    //3.end Ride
    public Ride endRide(Ride ride){
        return ride;
    }

    //4.list my ride
    public List<Ride> getMyRide(User user){
        return null;
    }

}

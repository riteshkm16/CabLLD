package io.riteshkm16.lld.cab.service;

import io.riteshkm16.lld.cab.model.Cab;
import io.riteshkm16.lld.cab.model.Ride;
import io.riteshkm16.lld.cab.model.User;
import io.riteshkm16.lld.cab.model.dto.Location;

import java.util.List;

public interface RideService {
    Ride bookRide(Location fromLocation, Location toLocation,User user);
    Ride startRide(Ride ride);
    Ride endRide(Ride ride);
    List<Ride> getMyRide(User user);
}

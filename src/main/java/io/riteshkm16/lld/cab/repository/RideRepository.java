package io.riteshkm16.lld.cab.repository;

import io.riteshkm16.lld.cab.model.Cab;
import io.riteshkm16.lld.cab.model.Ride;

import java.util.HashMap;
import java.util.List;

public class RideRepository implements InMemoryRepository<Ride> {

    private HashMap<Integer, Ride> rideList;
    private Integer autoIncrementId ;
    private Integer incrementId(){
        return ++this.autoIncrementId;
    }

    public RideRepository(HashMap<Integer,Ride> rideList,Integer autoIncrementId){
        this.rideList = rideList;
        this.autoIncrementId = autoIncrementId;
    }

    @Override
    public Ride save(Ride ride) {
        ride.setId(incrementId());
        this.rideList.put(ride.getId(),ride);
        return ride;
    }

    @Override
    public Ride update(Ride ride) {
        if(this.rideList.containsKey(ride.getId())){
            this.rideList.put(ride.getId(),ride);
            return ride;
        }
        return null;
    }

    @Override
    public Ride getById(Integer id) {
        return this.rideList.get(id);
    }

    @Override
    public List<Ride> getAll() {
        return null;
    }
}

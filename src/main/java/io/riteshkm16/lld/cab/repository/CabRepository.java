package io.riteshkm16.lld.cab.repository;

import io.riteshkm16.lld.cab.model.Cab;
import io.riteshkm16.lld.cab.model.dto.Location;

import java.util.*;

public class CabRepository implements InMemoryRepository<Cab> {


    private HashMap<Integer, Cab> cabList;
    private Integer autoIncrementId ;
    private Integer incrementId(){
        return ++this.autoIncrementId;
    }

    public CabRepository(HashMap<Integer,Cab> cabList,Integer autoIncrementId){
        this.autoIncrementId = autoIncrementId;
        this.cabList = cabList;
    }


    @Override
    public Cab save(Cab cab) {
        cab.setId(incrementId());
        cabList.put(cab.getId(),cab);
        return cab;
    }

    @Override
    public Cab update(Cab cab) {
        return cabList.put(cab.getId(),cab);
    }

    @Override
    public Cab getById(Integer id) {
        return cabList.get(id);
    }

    @Override
    public List<Cab> getAll() {
        return null;
    }

    public List<Cab> getAvailableCab(){
        List<Cab> availableCabs= new ArrayList<>();
        for (Map.Entry<Integer,Cab> cabEntry:this.cabList.entrySet()){
            if(cabEntry.getValue().isAvailable()){
                availableCabs.add(cabEntry.getValue());
            }
        }
        return availableCabs;
    }

}

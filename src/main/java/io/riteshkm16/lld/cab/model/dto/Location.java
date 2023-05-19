package io.riteshkm16.lld.cab.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Location{
    private Integer x,y;
    private String name;

    public static double getDistance(Location from ,Location to){
        return Math.sqrt(Math.abs(from.x - to.x)*Math.abs(from.x - to.x) +
                Math.abs(from.y - to.y)*Math.abs(from.y - to.y));
    }
}

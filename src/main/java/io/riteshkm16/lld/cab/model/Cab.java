package io.riteshkm16.lld.cab.model;


import io.riteshkm16.lld.cab.model.dto.Location;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper=true)
@SuperBuilder
public class Cab extends BaseEntity{
    private Location location;
    private String modelNo;
    private String registrationNumber ;
    private Integer driverId;
    private boolean isAvailable;
}

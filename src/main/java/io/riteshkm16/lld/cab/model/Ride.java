package io.riteshkm16.lld.cab.model;


import io.riteshkm16.lld.cab.model.dto.Location;
import io.riteshkm16.lld.cab.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper=true)
@SuperBuilder
public class Ride extends BaseEntity {
    private Integer userId;
    private Integer cabId;
    private Location fromLocation;
    private Location toLocation;
    private double distance;
    private double fare;
    private Status status = Status.UNKNOWN;
}

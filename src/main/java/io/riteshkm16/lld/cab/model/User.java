package io.riteshkm16.lld.cab.model;

import io.riteshkm16.lld.cab.model.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper=true)
@SuperBuilder
public class User extends BaseEntity{
    private String name;
    private String contact;
    private String email;
    private Role role;
}

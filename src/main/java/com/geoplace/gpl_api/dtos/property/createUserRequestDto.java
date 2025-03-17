package com.geoplace.gpl_api.dtos.property;

import lombok.Data;

@Data
public class createUserRequestDto {
    private String name;
    private String email;
    private String password;
}

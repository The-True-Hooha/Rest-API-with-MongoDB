package com.TheTrueHooha.Rest.API.with.MongoDB.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String city;
    private String Country;
    private String postCode;
}

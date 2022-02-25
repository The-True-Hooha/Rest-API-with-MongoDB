package com.TheTrueHooha.Rest.API.with.MongoDB.User;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;


@Data //annotates lombok to provide getters and setters
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private Address address;
    private List <String> favouriteSubjects;
    private BigDecimal booksMoney;
    private ZonedDateTime createdAt;


}

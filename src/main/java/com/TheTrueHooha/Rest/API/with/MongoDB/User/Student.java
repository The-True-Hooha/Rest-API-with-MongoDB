package com.TheTrueHooha.Rest.API.with.MongoDB.User;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Data //annotates lombok to provide getters and setters
@Document
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    @Indexed (unique = true)
    private String email;
    private Gender gender;
    private Address address;
    private List <String> favouriteFood;
    private BigDecimal feedingMoney;
    private LocalDateTime createdAt;


    public Student(String firstName,
                   String lastName,
                   String email,
                   Gender gender,
                   Address address,
                   List<String> favouriteFood,
                   BigDecimal feedingMoney,
                   LocalDateTime createdAt)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favouriteFood = favouriteFood;
        this.feedingMoney = feedingMoney;
        this.createdAt = createdAt;
    }
}

package com.andy.gestion_uai.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Employee extends User {
    private String firstname;
    private String lastname;
    private String address;
    private LocalDate birthday;
    private String birthplace;
}
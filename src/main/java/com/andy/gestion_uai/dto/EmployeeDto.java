package com.andy.gestion_uai.dto;

import com.andy.gestion_uai.model.Role;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.andy.gestion_uai.model.Employee}
 */
@Data
public class EmployeeDto implements Serializable {
    String name;
    String email;
    String password;
    Role role;
    String firstname;
    String lastname;
    String address;
    @Past
    LocalDate birthday;
    String birthplace;
}
package com.tennis.model.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PlayerDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Character gender;
    private Date dateOfBirth;
}

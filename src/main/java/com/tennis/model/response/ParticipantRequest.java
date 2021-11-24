package com.tennis.model.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ParticipantRequest {
    private String firstname;
    private String lastname;
    private String email;
    private Character gender;
    private Date dateofbirth;
    private Integer seed;
}

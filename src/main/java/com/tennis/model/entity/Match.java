package com.tennis.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "matches")
public class Match  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "first_registration_id")
    private Registration firstRegistrationId;
    @ManyToOne
    @JoinColumn(name = "second_registration_id")
    private Registration secondRegistrationId;
    private Integer round;

}

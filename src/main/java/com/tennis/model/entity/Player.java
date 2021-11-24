package com.tennis.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Player  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Character gender;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "registration_player",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "registration_id"))
    Set<Registration> registrations;
}

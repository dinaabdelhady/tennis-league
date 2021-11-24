package com.tennis.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(
        name = "registration_player",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"registration_id","player_id"})}
)
@IdClass(RegistrationPlayerId.class)
public class RegistrationPlayer  implements Serializable {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "registration_id")
    @Id
    private Registration registration;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "player_id")
    @Id
    private Player player;
}

package com.tennis.model.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Registration  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @ManyToMany(mappedBy = "registrations")
    Set<Player> players;
}

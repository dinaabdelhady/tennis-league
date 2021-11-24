package com.tennis.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(
        name = "game_score",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"match_id","game_number"})}
)
public class GameScore  implements Serializable {
    @ManyToOne
    @JoinColumn(name = "match_id")
    @Id
    private Match match;
    @Id
    @Column(name = "game_number")
    private Integer gameNumber;
    private Integer firstRegistrationPoint;
    private Integer secondRegistrationPoint;

}

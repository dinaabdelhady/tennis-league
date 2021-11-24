package com.tennis.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class MatchResult  implements Serializable {

    @EmbeddedId
    private MatchIdPK matchId;

    @OneToOne
    @JoinColumn(name = "match_id")
    @MapsId( "matchId" )
    private Match match;

    @ManyToOne
    @JoinColumn(name = "winner_registration_id")
    private Registration registration;

    private Integer numberOfSetsPlayed;

    @Column(name = "is_opponent_retired", columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean isOpponentRetired;

}

package com.tennis.model.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TournamentWinnerRequest {
    private Integer matchId;
    private Integer registrationId;
    private boolean isOpponentRetired;
}

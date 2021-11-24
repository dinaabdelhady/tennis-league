package com.tennis.service;

import com.tennis.model.request.TournamentWinnerRequest;
import com.tennis.model.response.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface TournamentService {
    ApiResponse updateTournamentWinner(TournamentWinnerRequest tournamentWinnerRequest);
}

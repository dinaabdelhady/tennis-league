package com.tennis.controller;

import com.tennis.model.request.TournamentWinnerRequest;
import com.tennis.model.response.ApiResponse;
import com.tennis.service.MatchService;
import com.tennis.service.TournamentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MatchesController {
    private MatchService matchService;
    private TournamentService tournamentService;

    public MatchesController(MatchService matchService,
                             TournamentService tournamentService) {
        this.matchService = matchService;
        this.tournamentService = tournamentService;
    }

    @GetMapping(path = "/v1/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getMatches() {
        ApiResponse apiResponse =  new ApiResponse();
        apiResponse.setStatusCode(1000);
        apiResponse.setStatusMessage("Success");
        apiResponse.setData(matchService.getMatches());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/v1/matches/{round}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getMatchesByRound(@PathVariable Integer round) {
        ApiResponse apiResponse =  new ApiResponse();
        apiResponse.setStatusCode(1000);
        apiResponse.setStatusMessage("Success");
        apiResponse.setData(matchService.getMatchesByRound(round));
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @PostMapping(value = "/v1/tournament", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> updateTournamentWinner(@RequestBody TournamentWinnerRequest tournamentWinnerRequest) {
        ApiResponse apiResponse = tournamentService.updateTournamentWinner(tournamentWinnerRequest);
        return new ResponseEntity<>(apiResponse, apiResponse.getStatusCode()==1000? HttpStatus.OK:HttpStatus.NOT_ACCEPTABLE);
    }
}

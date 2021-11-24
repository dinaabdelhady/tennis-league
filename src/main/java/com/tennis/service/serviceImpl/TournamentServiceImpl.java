package com.tennis.service.serviceImpl;

import com.tennis.model.entity.MatchIdPK;
import com.tennis.model.entity.MatchResult;
import com.tennis.model.request.TournamentWinnerRequest;
import com.tennis.model.response.ApiResponse;
import com.tennis.repository.MatchRepository;
import com.tennis.repository.MatchResultRepository;
import com.tennis.repository.RegistrationRepository;
import com.tennis.service.TournamentService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TournamentServiceImpl implements TournamentService {

    private MatchResultRepository matchResultRepository;
    private MatchRepository matchRepository;
    private RegistrationRepository registrationRepository;

    public TournamentServiceImpl(MatchResultRepository matchResultRepository,
                                 MatchRepository matchRepository,
                                 RegistrationRepository registrationRepository) {
        this.matchResultRepository = matchResultRepository;
        this.matchRepository = matchRepository;
        this.registrationRepository = registrationRepository;
    }

    @Override
    public ApiResponse updateTournamentWinner(TournamentWinnerRequest tournamentWinnerRequest) {
        ApiResponse apiResponse =  new ApiResponse();
        apiResponse.setStatusCode(4000);
        apiResponse.setStatusMessage("Fail");
        if(Objects.isNull(tournamentWinnerRequest.getMatchId())){
            apiResponse.setData("Match id is mandatory.");
        }else if(Objects.isNull(tournamentWinnerRequest.getRegistrationId())){
            apiResponse.setData("Winner Registration id is mandatory.");
        }else if(!matchRepository.existsById(tournamentWinnerRequest.getMatchId())) {
            apiResponse.setData("Match id doesn't found in the system.");
        }else if(!registrationRepository.existsById(tournamentWinnerRequest.getRegistrationId())){
            apiResponse.setData("Registration id doesn't found in the system.");
        }else if(matchResultRepository.existsById(new MatchIdPK(tournamentWinnerRequest.getMatchId()))){
            apiResponse.setData("Winner is already updated in the system with respect to given match id.");
        }else{
            MatchResult matchResult = new MatchResult();
            matchResult.setMatchId(new MatchIdPK(tournamentWinnerRequest.getMatchId()));
            matchResult.setMatch(matchRepository.findById(tournamentWinnerRequest.getMatchId()).get());
            matchResult.setIsOpponentRetired(tournamentWinnerRequest.isOpponentRetired());
            matchResult.setRegistration(registrationRepository.findById(tournamentWinnerRequest.getRegistrationId()).get());
            matchResultRepository.save(matchResult);
            apiResponse.setStatusCode(1000);
            apiResponse.setStatusMessage("Success");
            apiResponse.setData("League champion updated successfully.");
        }
        return apiResponse;
    }
}

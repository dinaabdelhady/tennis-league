package com.tennis.service;
import com.tennis.model.dto.MatchDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {
    List<MatchDto> getMatches();
    List<MatchDto> getMatchesByRound(Integer round);
}

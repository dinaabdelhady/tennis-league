package com.tennis.service;

import com.tennis.model.response.ApiResponse;
import com.tennis.model.response.ParticipantRequest;
import com.tennis.model.response.ParticipantResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParticipantService {
    List<ParticipantResponse> getAllParticipants();
    ApiResponse addNewParticipant(ParticipantRequest participantRequest);
}

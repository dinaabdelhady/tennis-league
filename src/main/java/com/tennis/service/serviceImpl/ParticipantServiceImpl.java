package com.tennis.service.serviceImpl;

import com.tennis.model.entity.Player;
import com.tennis.model.entity.PlayingIn;
import com.tennis.model.entity.Registration;
import com.tennis.model.entity.RegistrationPlayer;
import com.tennis.model.response.ApiResponse;
import com.tennis.model.response.ParticipantRequest;
import com.tennis.model.response.ParticipantResponse;
import com.tennis.repository.PlayerRepository;
import com.tennis.repository.PlayingInRepository;
import com.tennis.repository.RegistrationPlayerRepository;
import com.tennis.service.ParticipantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ParticipantServiceImpl implements ParticipantService {

    private PlayingInRepository playingInRepository;
    private RegistrationPlayerRepository registrationPlayerRepository;
    private PlayerRepository playerRepository;

    public ParticipantServiceImpl(PlayingInRepository playingInRepository,
                                  RegistrationPlayerRepository registrationPlayerRepository,
                                  PlayerRepository playerRepository) {
        this.playingInRepository = playingInRepository;
        this.registrationPlayerRepository = registrationPlayerRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public List<ParticipantResponse> getAllParticipants() {
        List<ParticipantResponse> participantResponses = new ArrayList<>();

        List<PlayingIn> playingIns = playingInRepository.findAll();
        if(!CollectionUtils.isEmpty(playingIns)){
            List<Registration> registrations = playingIns.stream().map(PlayingIn::getRegistration).collect(Collectors.toList());
            List<RegistrationPlayer> registrationPlayers = registrationPlayerRepository.findAllByRegistrationIn(registrations);
            participantResponses = registrationPlayers.stream().map(x->{
                ParticipantResponse participantResponse = new ParticipantResponse();
                participantResponse.setFirstName(x.getPlayer().getFirstName());
                participantResponse.setLastName(x.getPlayer().getLastName());
                participantResponse.setEmail(x.getPlayer().getEmail());
                return participantResponse;
            }).collect(Collectors.toList());
        }

        return participantResponses;
    }

    @Transactional
    public ApiResponse addNewParticipant(ParticipantRequest participantRequest){
        Player player = constructPlayerObject(participantRequest);
        ApiResponse apiResponse =  new ApiResponse();
        try {
            player = playerRepository.save(player);
            PlayingIn playingIn = new PlayingIn();
            playingIn.setRegistration(player.getRegistrations().stream().iterator().next());
            playingIn.setSeed(participantRequest.getSeed());
            playingInRepository.save(playingIn);

            apiResponse.setStatusCode(1000);
            apiResponse.setStatusMessage("Participant added successfully");
        } catch (Exception ex){
            ex.printStackTrace();
            log.error("Error while saving a new Participant >> {}", ex.getStackTrace());
            apiResponse.setStatusCode(500);
            apiResponse.setStatusMessage("Error while adding new Participant");
        }
        return apiResponse;
    }

    private Player constructPlayerObject(ParticipantRequest participantRequest) {
        Player player = new Player();
        player.setFirstName(participantRequest.getFirstname());
        player.setLastName(participantRequest.getLastname());
        player.setEmail(participantRequest.getEmail());
        player.setGender(participantRequest.getGender());
        player.setDateOfBirth(participantRequest.getDateofbirth());
        Set p = new HashSet();
        Set r = new HashSet();

        Registration registration = new Registration();
        registration.setRegistrationDate(new Date());
        r.add(registration);

        player.setRegistrations(r);
        return player;
    }
}

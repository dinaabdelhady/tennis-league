package com.tennis.controller;

import com.tennis.model.response.ApiResponse;
import com.tennis.model.response.ParticipantRequest;
import com.tennis.service.ParticipantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ParticipantsController {

    private ParticipantService participantService;

    public ParticipantsController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping(path = "/v1/participants", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getParticipants() {
        ApiResponse apiResponse =  new ApiResponse();
        apiResponse.setStatusCode(1000);
        apiResponse.setStatusMessage("Success");
        apiResponse.setData(participantService.getAllParticipants());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping(path = "/v1/participants", produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> addParticipant(@RequestBody ParticipantRequest request) {
        ApiResponse apiResponse =
                    participantService.addNewParticipant(request);

        return new ResponseEntity<>(apiResponse, apiResponse.getStatusCode()==1000? HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public ResponseEntity<String> defaultMethod() {
        return new ResponseEntity<>("Welcome to the tennis league!!!", HttpStatus.OK);
    }

}

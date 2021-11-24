package com.tennis.api;

import com.tennis.controller.ParticipantsController;
import com.tennis.model.response.ApiResponse;
import com.tennis.model.response.ParticipantResponse;
import com.tennis.service.ParticipantService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ParticipantControllerUnitTest {

    @InjectMocks
    private ParticipantsController participantController;

    @Mock
    private ParticipantService participantService;

    @Test
    public void getParticipants(){
        List<ParticipantResponse> participantResponses = getParticipantsResponse();
        when(participantService.getAllParticipants()).thenReturn(participantResponses);
        ResponseEntity<ApiResponse> response = participantController.getParticipants();
        Assert.assertNotNull(response);
        Assert.assertSame(participantResponses, Objects.requireNonNull(response.getBody()).getData());
    }

    /**
     * This method will help to create ParticipantResponse related DTO Objects.
     * @return List<ParticipantResponse>
     */
    private List<ParticipantResponse> getParticipantsResponse() {
        List<ParticipantResponse> participantResponses = new ArrayList<>();
        ParticipantResponse participantResponse = new ParticipantResponse();
        participantResponse.setFirstName("ABC");
        participantResponse.setLastName("XYZ");
        participantResponse.setEmail("abc@xyz.com");
        participantResponses.add(participantResponse);
        return participantResponses;
    }

}

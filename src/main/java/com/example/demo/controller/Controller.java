package com.example.demo.controller;

import com.example.demo.models.Participant;
import com.example.demo.models.Response;
import com.example.demo.service.ParticipantServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private final ParticipantServices participantServices;

    public Controller(ParticipantServices participantServices) {
        this.participantServices = participantServices;
    }
    @Operation(summary = "Add participant")
    @PostMapping("/add-participant")
    public ResponseEntity<Response<String>> addParticipants(@RequestBody List<Participant> participants){
        boolean isSucced = participantServices.addParticipants(participants);
        if (isSucced){
            return ResponseEntity.ok(new Response<>(HttpStatus.OK.value(),"Participants added"));
        }
        return ResponseEntity.ok(new Response<>(HttpStatus.EXPECTATION_FAILED.value(), "Error adding participants"));
    }
    @Operation(summary = "Verify participant")
    @PostMapping("/verify-participant")
    public ResponseEntity<Response<String>> verifyParticipants(@RequestBody Participant participant){
        boolean isSucceed = participantServices.verifyParticipant(participant);
        if (isSucceed){
            return ResponseEntity.ok(new Response<>(HttpStatus.OK.value(),"Participant verified"));
        }
        return ResponseEntity.ok(new Response<>(HttpStatus.EXPECTATION_FAILED.value(), "Error verifing participants"));
    }
}

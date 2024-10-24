package com.example.demo.service;

import com.example.demo.Repo.ParticipantRepo;
import com.example.demo.exceptions.ResourceAlreadyExistsException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Participant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantServices {
    private final ParticipantRepo participantRepo;

    public ParticipantServices(ParticipantRepo participantRepo) {
        this.participantRepo = participantRepo;
    }

    public boolean addParticipants(List<Participant> participants){
        participantRepo.saveAll(participants);
        return true;
    }
    public boolean verifyParticipant(Participant participant){
        Participant participant1 = participantRepo.fetchParticipant(participant.getReg(), participant.getName()).orElseThrow(
                ()-> new ResourceNotFoundException("Participant not found.")
        );
        if (participant1.isVerified()){
            throw new ResourceAlreadyExistsException("Participant already verified");
        }
        participant1.setVerified(true);
        participantRepo.save(participant1);
        return true;
    }
}

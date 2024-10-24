package com.example.demo.Repo;

import com.example.demo.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRepo extends JpaRepository<Participant,String> {
    @Query("SELECT p FROM Participant p WHERE p.reg = :reg AND p.name = :name")
    Optional<Participant> fetchParticipant(String reg,String name);
}

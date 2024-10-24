package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Participant {
    @Id
    private String reg;
    private String name;
    private boolean isVerified;
}

package com.agria.studentRepo.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long playerId;
    private String playerName;
    private byte age;
    private int score;
}

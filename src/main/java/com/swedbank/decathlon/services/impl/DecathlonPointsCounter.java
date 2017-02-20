package com.swedbank.decathlon.services.impl;

import com.swedbank.decathlon.domain.DecathlonAthlete;

import static com.swedbank.decathlon.domain.DecathlonPointsTable.*;

public class DecathlonPointsCounter extends MultiEventPointCounter<DecathlonAthlete> {
    @Override
    protected void countPointsSingle(DecathlonAthlete athlete) {
        int totalScore = 0;

        totalScore += M100.calculateEventScore(athlete.getM100().toMillis() / 1000.0);
        totalScore += LONG_JUMP.calculateEventScore(athlete.getLongJump());
        totalScore += SHOT_PUT.calculateEventScore(athlete.getShotPut());
        totalScore += HIGH_JUMP.calculateEventScore(athlete.getHighJump());
        totalScore += M400.calculateEventScore(athlete.getM400().toMillis() / 1000.0);
        totalScore += M110.calculateEventScore(athlete.getM110h().toMillis() / 1000.0);
        totalScore += DISCUS_THROW.calculateEventScore(athlete.getDiscusThrow());
        totalScore += POLE_VAULT.calculateEventScore(athlete.getPoleVault());
        totalScore += JAVELIN_THROW.calculateEventScore(athlete.getJavelinThrow());
        totalScore += M1500.calculateEventScore(athlete.getM1500().toMillis() / 1000.0);

        athlete.setTotalScore(totalScore);
    }
}

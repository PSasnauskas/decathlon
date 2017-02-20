package com.swedbank.decathlon.domain;

import java.time.Duration;

public class DecathlonAthlete extends Athlete {

    private Duration m100;
    private Double longJump;
    private Double shotPut;
    private Double highJump;
    private Duration m400;
    private Duration m110h;
    private Double discusThrow;
    private Double poleVault;
    private Double javelinThrow;
    private Duration m1500;

    public DecathlonAthlete(String name, Integer totalScore, Duration m100, Double longJump, Double shotPut, Double highJump,
                            Duration m400, Duration m110h, Double discusThrow, Double poleVault, Double javelinThrow, Duration m1500) {
        super(name, totalScore);

        this.m100 = m100;
        this.longJump = longJump;
        this.shotPut = shotPut;
        this.highJump = highJump;
        this.m400 = m400;
        this.m110h = m110h;
        this.discusThrow = discusThrow;
        this.poleVault = poleVault;
        this.javelinThrow = javelinThrow;
        this.m1500 = m1500;
    }

    public Duration getM100() {
        return m100;
    }

    public Double getLongJump() {
        return longJump;
    }

    public Double getShotPut() {
        return shotPut;
    }

    public Double getHighJump() {
        return highJump;
    }

    public Duration getM400() {
        return m400;
    }

    public Duration getM110h() {
        return m110h;
    }

    public Double getDiscusThrow() {
        return discusThrow;
    }

    public Double getPoleVault() {
        return poleVault;
    }

    public Double getJavelinThrow() {
        return javelinThrow;
    }

    public Duration getM1500() {
        return m1500;
    }
}

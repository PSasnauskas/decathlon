package com.swedbank.decathlon;

import com.swedbank.decathlon.domain.DecathlonAthlete;

import java.time.Duration;

public class TestBase {

    protected DecathlonAthlete createAthlete(String name, Integer totalScore) {
        Duration anyDuration = Duration.ofMinutes(1);
        Double anyDistance = 100d;

        return new DecathlonAthlete(name, totalScore, anyDuration, anyDistance,
                anyDistance, anyDistance, anyDuration, anyDuration, anyDistance, anyDistance, anyDistance, anyDuration);
    }

}

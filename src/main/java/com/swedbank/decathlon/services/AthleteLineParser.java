package com.swedbank.decathlon.services;

import com.swedbank.decathlon.domain.Athlete;

import java.util.List;

public interface AthleteLineParser<A extends Athlete> {

    void parseLine(String line);

    List<A> getParsedAthletes();

    /**
     * Line parser must be reset on each file
     * to clear it's in memory cache.
     */
    void reset();
}

package com.swedbank.decathlon.services.impl;

import com.swedbank.decathlon.domain.Athlete;
import com.swedbank.decathlon.services.AthleteLineParser;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericAthleteLineParser<A extends Athlete> implements AthleteLineParser<A> {

    private List<A> parsedAthletes;

    protected void addAthlete(A athlete) {
        this.parsedAthletes.add(athlete);
    }

    @Override
    public List<A> getParsedAthletes() {
        return parsedAthletes;
    }

    @Override
    public void reset() {
        parsedAthletes = new ArrayList<>();
    }
}

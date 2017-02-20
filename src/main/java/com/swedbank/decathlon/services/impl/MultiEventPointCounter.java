package com.swedbank.decathlon.services.impl;

import com.swedbank.decathlon.domain.Athlete;
import com.swedbank.decathlon.services.PointsCounter;

import java.util.List;


public abstract class MultiEventPointCounter<A extends Athlete> implements PointsCounter<A> {

    public void countPoints(List<A> athletes) {
        for (A athlete : athletes) {
            countPointsSingle(athlete);
        }
    }

    protected abstract void countPointsSingle(A athlete);
}

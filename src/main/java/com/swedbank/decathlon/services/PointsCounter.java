package com.swedbank.decathlon.services;

import com.swedbank.decathlon.domain.Athlete;

import java.util.List;

public interface PointsCounter<A extends Athlete> {

    void countPoints(List<A> athletes);

}

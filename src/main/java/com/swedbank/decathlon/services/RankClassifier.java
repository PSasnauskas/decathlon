package com.swedbank.decathlon.services;

import com.swedbank.decathlon.domain.Athlete;

import java.util.List;

public interface RankClassifier<A extends Athlete> {

    List<A> classifyRank(List<A> athletes);

}

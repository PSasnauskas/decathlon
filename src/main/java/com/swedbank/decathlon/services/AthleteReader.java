package com.swedbank.decathlon.services;

import com.swedbank.decathlon.domain.Athlete;

import java.util.List;

public interface AthleteReader<A extends Athlete> extends TypedFileHandler {

    List<A> readAthletes(String fileName);

}

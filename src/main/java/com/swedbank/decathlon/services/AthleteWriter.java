package com.swedbank.decathlon.services;

import com.swedbank.decathlon.domain.Athlete;

import java.util.List;

public interface AthleteWriter<E extends Athlete> extends TypedFileHandler {

    void writeAthletes(List<E> athletes, String fileName);

}

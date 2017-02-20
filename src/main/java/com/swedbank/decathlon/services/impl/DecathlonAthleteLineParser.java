package com.swedbank.decathlon.services.impl;

import com.swedbank.decathlon.domain.DecathlonAthlete;
import com.swedbank.decathlon.services.impl.GenericAthleteLineParser;
import com.swedbank.decathlon.utils.DurationParser;

import java.time.Duration;

public class DecathlonAthleteLineParser extends GenericAthleteLineParser<DecathlonAthlete> {

    public static final String FIELD_SEPARATOR = ";";

    @Override
    public void parseLine(String line) {
        String[] fields = line.split(FIELD_SEPARATOR);

        String name = fields[0];
        Duration m100 = DurationParser.parse(fields[1]);
        Double longJump = Double.parseDouble(fields[2]);
        Double shotPut = Double.parseDouble(fields[3]);
        Double highJump = Double.parseDouble(fields[4]);
        Duration m400 = DurationParser.parse(fields[5]);
        Duration m110h = DurationParser.parse(fields[6]);
        Double discusThrow = Double.parseDouble(fields[7]);
        Double poleVault = Double.parseDouble(fields[8]);
        Double javelinThrow = Double.parseDouble(fields[9]);
        Duration m1500 = DurationParser.parse(fields[10]);

        DecathlonAthlete athlete = new DecathlonAthlete(name, null, m100, longJump, shotPut, highJump, m400,
                m110h, discusThrow, poleVault, javelinThrow, m1500);

        getParsedAthletes().add(athlete);
    }
}

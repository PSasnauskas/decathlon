package com.swedbank.decathlon.services.impl;

import com.swedbank.decathlon.domain.DecathlonAthlete;
import com.swedbank.decathlon.utils.DurationParser;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DecathlonAthleteLineParserTest {

    @Test
    public void parseLine() throws Exception {
        DecathlonAthleteLineParser parser = new DecathlonAthleteLineParser();
        parser.reset();

        parser.parseLine(getAthleteLine("Siim Susi", 5000));

        DecathlonAthlete athlete = parser.getParsedAthletes().get(0);

        assertThat(athlete.getName(), equalTo("Siim Susi"));
        assertThat(athlete.getM100(), equalTo(DurationParser.parse("12.61")));
        assertThat(athlete.getLongJump(), equalTo(Double.parseDouble("5.00")));
        assertThat(athlete.getShotPut(), equalTo(Double.parseDouble("9.22")));
        assertThat(athlete.getHighJump(), equalTo(Double.parseDouble("1.50")));
        assertThat(athlete.getM400(), equalTo(DurationParser.parse("60.39")));
        assertThat(athlete.getM110h(), equalTo(DurationParser.parse("16.43")));
        assertThat(athlete.getDiscusThrow(), equalTo(Double.parseDouble("21.60")));
        assertThat(athlete.getPoleVault(), equalTo(Double.parseDouble("2.60")));
        assertThat(athlete.getJavelinThrow(), equalTo(Double.parseDouble("35.81")));
        assertThat(athlete.getM1500(), equalTo(DurationParser.parse("5.25.72")));
    }

    private String getAthleteLine(String name, Integer totalScore) {
        final String separator = ";";

        StringBuilder sb = new StringBuilder();
        sb.append(name).append(separator);
        sb.append("12.61").append(separator);
        sb.append("5.00").append(separator);
        sb.append("9.22").append(separator);
        sb.append("1.50").append(separator);
        sb.append("60.39").append(separator);
        sb.append("16.43").append(separator);
        sb.append("21.60").append(separator);
        sb.append("2.60").append(separator);
        sb.append("35.81").append(separator);
        sb.append("5.25.72").append(separator);

        return sb.toString();
    }
}
package com.swedbank.decathlon.services.impl;

import com.swedbank.decathlon.TestBase;
import com.swedbank.decathlon.domain.DecathlonAthlete;
import com.swedbank.decathlon.utils.DurationParser;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DecathlonPointsCounterTest extends TestBase {

    @Test
    public void countPointsSingle() throws Exception {
        DecathlonAthlete athlete = create1000ptsAthlete("Siim Susi");

        DecathlonPointsCounter pointsCounter = new DecathlonPointsCounter();
        pointsCounter.countPointsSingle(athlete);

        assertThat(athlete.getTotalScore(), equalTo(9990));
    }

    private DecathlonAthlete create1000ptsAthlete(String name) {
        DecathlonAthlete athlete = new DecathlonAthlete(name, 0,
                DurationParser.parse("10.395"),
                Double.parseDouble("7.76"),
                Double.parseDouble("18.4"),
                Double.parseDouble("2.2"),
                DurationParser.parse("46.17"),
                DurationParser.parse("13.8"),
                Double.parseDouble("56.17"),
                Double.parseDouble("5.28"),
                Double.parseDouble("77.19"),
                DurationParser.parse("3.53.79"));

        return athlete;
    }
}
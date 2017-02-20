package com.swedbank.decathlon.services.impl;

import com.swedbank.decathlon.TestBase;
import com.swedbank.decathlon.domain.DecathlonAthlete;
import com.swedbank.decathlon.services.PointsCounter;
import com.swedbank.decathlon.services.RankClassifier;
import org.junit.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DecathlonRankClassifierTest extends TestBase {

    @Test
    public void classifyRank() throws Exception {
        RankClassifier<DecathlonAthlete> rankClassifier = new DecathlonRankClassifier(getPointsCounterStub());
        List<DecathlonAthlete> athletes = Arrays.asList(createAthlete("Bill", 5000),
                createAthlete("Linus", 4000),
                createAthlete("Steve", 5000),
                createAthlete("Dennis", 8000),
                createAthlete("Robert", 7000),
                createAthlete("Mark", 5000));

        rankClassifier.classifyRank(athletes);

        assertThat(athletes.get(0).getName(), equalTo("Dennis"));
        assertThat(athletes.get(0).getRank().toString(), equalTo("1"));
        assertThat(athletes.get(1).getName(), equalTo("Robert"));
        assertThat(athletes.get(1).getRank().toString(), equalTo("2"));
        assertThat(athletes.get(2).getRank().toString(), equalTo("3-5"));
        assertThat(athletes.get(3).getRank().toString(), equalTo("3-5"));
        assertThat(athletes.get(4).getRank().toString(), equalTo("3-5"));
        assertThat(athletes.get(5).getName(), equalTo("Linus"));
        assertThat(athletes.get(5).getRank().toString(), equalTo("6"));
        assertThat(athletes.get(5).getRank().getScore(), equalTo(4000d));
    }

    private PointsCounter<DecathlonAthlete> getPointsCounterStub() {
        return new PointsCounter<DecathlonAthlete>() {
            @Override
            public void countPoints(List<DecathlonAthlete> athletes) {

            }
        };
    }

}
package com.swedbank.decathlon.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class RankingTest {

    @Test
    public void rankSingle() throws Exception {
        Ranking ranking = new Ranking(1000.0);
        ranking.addPos(1);

        String targetRank = "1";

        assertThat(ranking.toString(), equalTo(targetRank));
    }

    @Test
    public void rankMulti() throws Exception {
        Ranking ranking = new Ranking(1000.0);
        ranking.addPos(3);
        ranking.addPos(4);
        ranking.addPos(5);

        String targetRank = "3-5";

        assertThat(ranking.toString(), equalTo(targetRank));
    }

}
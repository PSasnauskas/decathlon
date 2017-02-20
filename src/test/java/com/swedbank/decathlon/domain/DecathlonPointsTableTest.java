package com.swedbank.decathlon.domain;

import com.swedbank.decathlon.utils.DurationParser;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DecathlonPointsTableTest {

    @Test
    public void testM100() {
        int score = DecathlonPointsTable.M100.calculateEventScore(getMillis("10.395"));

        assertThat(score, equalTo(1000));
    }

    @Test
    public void testLongJump() {
        int score = DecathlonPointsTable.LONG_JUMP.calculateEventScore(7.76);

        assertThat(score, equalTo(1000));
    }

    @Test
    public void testShotPut() {
        int score = DecathlonPointsTable.SHOT_PUT.calculateEventScore(18.4);

        assertThat(score, equalTo(1000));
    }

    @Test
    public void testHighJump() {
        int score = DecathlonPointsTable.HIGH_JUMP.calculateEventScore(2.2);

        assertThat(score, equalTo(992));
    }

    @Test
    public void testM400() {
        int score = DecathlonPointsTable.M400.calculateEventScore(getMillis("46.17"));

        assertThat(score, equalTo(1000));
    }

    @Test
    public void testM110() {
        int score = DecathlonPointsTable.M110.calculateEventScore(getMillis("13.8"));

        assertThat(score, equalTo(1000));
    }

    @Test
    public void testDiscusThrow() {
        int score = DecathlonPointsTable.DISCUS_THROW.calculateEventScore(56.17);

        assertThat(score, equalTo(1000));
    }

    @Test
    public void testPoleVault() {
        int score = DecathlonPointsTable.POLE_VAULT.calculateEventScore(5.28);

        assertThat(score, equalTo(998));
    }

    @Test
    public void testJavelinThrow() {
        int score = DecathlonPointsTable.JAVELIN_THROW.calculateEventScore(77.19);

        assertThat(score, equalTo(1000));
    }

    @Test
    public void testM1500() {
        int score = DecathlonPointsTable.M1500.calculateEventScore(getMillis("3.53.79"));

        assertThat(score, equalTo(1000));
    }

    private double getMillis(String value) {
        return DurationParser.parse(value).toMillis() / 1000.0;
    }
}
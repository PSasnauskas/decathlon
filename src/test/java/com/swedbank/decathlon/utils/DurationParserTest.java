package com.swedbank.decathlon.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

import java.time.Duration;

public class DurationParserTest {

    @Test
    public void parseWithMinutes() throws Exception {
        Duration parsedDuration = DurationParser.parse("5.25.72");
        Duration targetDuration = Duration.ofMinutes(5).plusSeconds(25).plusMillis(720);

        assertThat(parsedDuration, equalTo(targetDuration));
    }

    @Test
    public void parseSecondsAndMillis() throws Exception {
        Duration parsedDuration = DurationParser.parse("12.61");
        Duration targetDuration = Duration.ofSeconds(12).plusMillis(610);

        assertThat(parsedDuration, equalTo(targetDuration));
    }

}
package com.swedbank.decathlon.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

import java.time.Duration;

public class DurationFormatterTest {

    @Test
    public void formatDurationWithMinutes() {
        Duration duration = Duration.ofMinutes(5).plusSeconds(25).plusMillis(720);
        String formattedDuration = DurationFormatter.formatDuration(duration);
        String target = "5:25.720";

        assertThat(formattedDuration, equalTo(target));
    }

    @Test
    public void formatDurationSecondsAndMillis() {
        Duration duration = Duration.ofSeconds(12).plusMillis(610);
        String formattedDuration = DurationFormatter.formatDuration(duration);
        String target = "12.610";

        assertThat(formattedDuration, equalTo(target));
    }

}
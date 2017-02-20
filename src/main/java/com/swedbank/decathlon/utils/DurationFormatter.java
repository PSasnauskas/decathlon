package com.swedbank.decathlon.utils;

import java.time.Duration;

public class DurationFormatter {
    private static final String FORMAT_SECONDS_MILLIS = "%d.%02d";
    private static final String FORMAT_MINUTES_SECONDS_MILLIS = "%d:%02d.%02d";
    private static final int MILLIS_IN_SECOND = 1000;
    private static final long MILLIS_IN_MINUTE = 60 * MILLIS_IN_SECOND;

    public static String formatDuration(Duration duration) {
        long millisTotal = Math.abs(duration.toMillis());

        long minutes = millisTotal / MILLIS_IN_MINUTE;
        long seconds = (millisTotal % MILLIS_IN_MINUTE) / MILLIS_IN_SECOND;
        long millis = millisTotal % MILLIS_IN_SECOND;

        if (minutes > 0) {
            return String.format(FORMAT_MINUTES_SECONDS_MILLIS,
                    minutes,
                    seconds,
                    millis);
        } else {
            return String.format(FORMAT_SECONDS_MILLIS,
                    seconds,
                    millis);
        }
    }
}
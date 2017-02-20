package com.swedbank.decathlon.utils;

import java.time.Duration;

public class DurationParser {
    public static final String SEPARATOR = ".";
    private static final String REGEX_ESC = "\\";

    public static Duration parse(String input) {
        String[] parts = input.split(REGEX_ESC + SEPARATOR);

        long minutes = parts.length > 2 ? Long.valueOf(parts[parts.length - 3]) : 0l;
        long seconds = Long.valueOf(parts[parts.length - 2]);
        long millis = Double.valueOf(Double.valueOf(SEPARATOR + parts[parts.length - 1]) * 1000).longValue();

        return Duration.ofMinutes(minutes).plusSeconds(seconds).plusMillis(millis);
    }
}

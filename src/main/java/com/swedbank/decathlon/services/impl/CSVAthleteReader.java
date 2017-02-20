package com.swedbank.decathlon.services.impl;

import com.swedbank.decathlon.domain.Athlete;
import com.swedbank.decathlon.services.AthleteLineParser;
import com.swedbank.decathlon.services.AthleteReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class CSVAthleteReader<A extends Athlete> implements AthleteReader<A> {

    public static final String SUPPORTED_FILE_EXTENSION = "csv";

    private AthleteLineParser lineParser;

    public CSVAthleteReader(AthleteLineParser<A> lineParser) {
        this.lineParser = lineParser;
    }

    @Override
    public List<A> readAthletes(String fileName) {
        lineParser.reset();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(lineParser::parseLine);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineParser.getParsedAthletes();
    }

    @Override
    public String getSupportedExtension() {
        return SUPPORTED_FILE_EXTENSION;
    }
}

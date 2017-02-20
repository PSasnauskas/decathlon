package com.swedbank.decathlon.config;

import com.swedbank.decathlon.domain.Athlete;
import com.swedbank.decathlon.services.AthleteReader;
import com.swedbank.decathlon.services.AthleteWriter;
import com.swedbank.decathlon.services.RankClassifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Project context configuration. IoC.
 */
public class Context {

    private List<AthleteWriter> writers;
    private List<AthleteReader> readers;
    private RankClassifier rankClassifier;


    public Context(List<AthleteReader> readers, List<AthleteWriter> writers, RankClassifier rankClassifier) {
        this.readers = readers;
        this.writers = writers;
        this.rankClassifier = rankClassifier;
    }

    public void processData(List<String> inputFileNames, String outputFileName) {
        Map<String, AthleteReader> readerMap = getReaders().stream().collect(Collectors.toMap(AthleteReader::getSupportedExtension, r -> r));
        Map<String, AthleteWriter> writerMap = getWriters().stream().collect(Collectors.toMap(AthleteWriter::getSupportedExtension, w -> w));

        List<? extends Athlete> athletes = new ArrayList<>();
        for (String fileName : inputFileNames) {
            athletes.addAll(readerMap.get(getExtension(fileName)).readAthletes(fileName));
        }

        rankClassifier.classifyRank(athletes);

        writerMap.get(getExtension(outputFileName)).writeAthletes(athletes, outputFileName);
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }

    protected List<AthleteWriter> getWriters() {
        return writers;
    }

    protected List<AthleteReader> getReaders() {
        return readers;
    }
}

package com.swedbank.decathlon;

import com.swedbank.decathlon.config.Context;
import com.swedbank.decathlon.services.AthleteReader;
import com.swedbank.decathlon.services.AthleteWriter;
import com.swedbank.decathlon.services.FileHandlerValidator;
import com.swedbank.decathlon.services.RankClassifier;
import com.swedbank.decathlon.services.TypedFileHandler;
import com.swedbank.decathlon.services.impl.CSVAthleteReader;
import com.swedbank.decathlon.services.impl.DecathlonAthleteLineParser;
import com.swedbank.decathlon.services.impl.DecathlonDomBuilder;
import com.swedbank.decathlon.services.impl.DecathlonPointsCounter;
import com.swedbank.decathlon.services.impl.DecathlonRankClassifier;
import com.swedbank.decathlon.services.impl.XMLDecathlonAthleteWriter;
import com.swedbank.decathlon.services.impl.FileHandlerValidatorImpl;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * Main Application Runner
 */
public class App {

    private static final String XSLT_PARAM_NAME = "xslt";
    private static final String VALIDATE_READER_MSG = "Supported Reader not found for file \"%s\". Supported input file types: %s";
    private static final String VALIDATE_WRITER_MSG = "Supported Writer not found for file \"%s\". Supported output file types: %s";

    public static void main(String[] args) {
        out.printf("Executing program with inline arguments: %s\n", Arrays.asList(args));

        validateUserInput(args);

        List<String> inputFileNames = Arrays.asList(Arrays.copyOfRange(args, 0, args.length - 1));
        String outputFileName = args[args.length - 1];
        List<AthleteReader> readers = getReaders();
        List<AthleteWriter> writers = getWriters(System.getProperty(XSLT_PARAM_NAME));

        validateFileTypeHandling(readers, VALIDATE_READER_MSG, inputFileNames.toArray(new String[0]));
        validateFileTypeHandling(writers, VALIDATE_WRITER_MSG, outputFileName);

        Context context = new Context(readers, writers, getRankClassifier());
        context.processData(inputFileNames, outputFileName);

        out.printf("End of program execution");
    }

    private static void validateUserInput(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("At least single input and single output file names must be provided");
        }

        for (String inputFile : args) {
            if (!inputFile.contains(".")) {
                throw new RuntimeException(String.format("File \"%s\" does not contain extension", inputFile));
            }
        }
    }

    private static void validateFileTypeHandling(List<? extends TypedFileHandler> fileHandlers, String msgFormat, String... fileNames) {
        FileHandlerValidator validator = new FileHandlerValidatorImpl(fileHandlers, msgFormat);

        for (String fileName : fileNames) {
            validator.validate(fileName);
        }

        if (!validator.validationSuccessful()) {
            throw new RuntimeException(String.valueOf(validator.getValidationMessages()));
        }
    }

    private static List<AthleteReader> getReaders() {
        return Arrays.asList(new CSVAthleteReader<>(new DecathlonAthleteLineParser()));
    }

    private static List<AthleteWriter> getWriters(String xsltFileName) {
        return Arrays.asList(new XMLDecathlonAthleteWriter(new DecathlonDomBuilder(xsltFileName)));
    }

    private static RankClassifier getRankClassifier() {
        return new DecathlonRankClassifier(new DecathlonPointsCounter());
    }
}

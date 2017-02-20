package com.swedbank.decathlon.services.impl;

import com.swedbank.decathlon.services.FileHandlerValidator;
import com.swedbank.decathlon.services.TypedFileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandlerValidatorImpl implements FileHandlerValidator {

    private List<String> validationMessages;
    private List<String> supportedExtensions;
    private String msgFormat;

    public FileHandlerValidatorImpl(List<? extends TypedFileHandler> fileHandlers, String msgFormat) {
        this.msgFormat = msgFormat;
        validationMessages = new ArrayList<>();
        supportedExtensions = fileHandlers.stream().map(TypedFileHandler::getSupportedExtension).collect(Collectors.toList());
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }

    @Override
    public boolean validate(String... fileNames) {
        for (String fileName : fileNames) {
            if (!supportedExtensions.contains(getExtension(fileName))) {
                validationMessages.add(String.format(msgFormat, fileName, supportedExtensions));
            }
        }

        return validationSuccessful();
    }

    @Override
    public List<String> getValidationMessages() {
        return validationMessages;
    }

    @Override
    public boolean validationSuccessful() {
        return validationMessages.isEmpty();
    }
}

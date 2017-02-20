package com.swedbank.decathlon.services.impl;

import com.swedbank.decathlon.services.FileHandlerValidator;
import com.swedbank.decathlon.services.TypedFileHandler;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class FileHandlerValidatorImplTest {

    private static final String VALIDATE_READER_MSG = "Supported Reader not found for file \"%s\". Supported input file types: %s";

    @Test
    public void successfulValidation() throws Exception {
        List<TypedFileHandler> fileHandlers = Arrays.asList(getFileHandler("csv"), getFileHandler("xml"));
        FileHandlerValidator validator = new FileHandlerValidatorImpl(fileHandlers, VALIDATE_READER_MSG);

        validator.validate("athletes.csv", "athletes.xml", "athletesExtra.csv");

        assertThat(validator.validationSuccessful(), equalTo(Boolean.TRUE));
        assertThat(validator.getValidationMessages().size(), equalTo(0)); //list is empty
    }

    @Test
    public void failedValidation() throws Exception {
        List<TypedFileHandler> fileHandlers = Arrays.asList(getFileHandler("xsl"));
        FileHandlerValidator validator = new FileHandlerValidatorImpl(fileHandlers, VALIDATE_READER_MSG);

        validator.validate("athletes.csv");

        assertThat(validator.validationSuccessful(), equalTo(Boolean.FALSE));
        assertThat(validator.getValidationMessages().size(), equalTo(1)); //list is empty
        assertThat(validator.getValidationMessages(), hasItem(String.format(VALIDATE_READER_MSG, "athletes.csv", Arrays.asList("xsl"))));
    }

    @Test
    public void failedMultiMsgValidation() {
        List<TypedFileHandler> fileHandlers = Arrays.asList(getFileHandler("xsl"), getFileHandler("txt"));
        FileHandlerValidator validator = new FileHandlerValidatorImpl(fileHandlers, VALIDATE_READER_MSG);

        validator.validate("athletes.csv", "athletes.xml", "athletesExtra.csv");

        assertThat(validator.validationSuccessful(), equalTo(Boolean.FALSE));
        assertThat(validator.getValidationMessages().size(), equalTo(3)); //list is empty
    }

    private TypedFileHandler getFileHandler(String extension) {
        return new TypedFileHandler() {

            @Override
            public String getSupportedExtension() {
                return extension;
            }
        };
    }

}
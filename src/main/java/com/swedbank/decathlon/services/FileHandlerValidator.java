package com.swedbank.decathlon.services;

import java.util.List;

public interface FileHandlerValidator {

    boolean validate(String... fileName);

    List<String> getValidationMessages();

    boolean validationSuccessful();
}

package br.com.leoamorimr.pethealthy.pethealthybackend.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    /**
     * @param status
     * @param msg
     * @param timesTamp
     */
    public ValidationError(Integer status, String msg, Long timesTamp) {
        super(status, msg, timesTamp);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
}
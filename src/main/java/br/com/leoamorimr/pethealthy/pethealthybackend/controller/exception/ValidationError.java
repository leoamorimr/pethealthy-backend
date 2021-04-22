package br.com.leoamorimr.pethealthy.pethealthybackend.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> messageList = new ArrayList<>();

    /**
     * @param status
     * @param msg
     * @param timesTamp
     */
    public ValidationError(Integer status, String msg, Long timesTamp) {
        super(status, msg, timesTamp);
    }

    public List<FieldMessage> getMessageList() {
        return messageList;
    }

    public void addError(String fieldName, String message) {
        messageList.add(new FieldMessage(fieldName, message));
    }
}
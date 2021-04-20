package br.com.leoamorimr.pethealthy.pethealthybackend.controller.exception;

import java.time.LocalDateTime;

import lombok.Data;

public class ErrorDetail {

    private LocalDateTime currentDateTime;
    private String message;

    /**
     * @param currentDate
     * @param message
     */
    public ErrorDetail(LocalDateTime currentDate, String message) {
        this.currentDateTime = currentDate;
        this.message = message;
    }

    public ErrorDetail() {
    }

    public LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(LocalDateTime currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

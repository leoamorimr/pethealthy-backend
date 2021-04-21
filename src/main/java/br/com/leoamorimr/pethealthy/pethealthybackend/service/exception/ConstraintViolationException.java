package br.com.leoamorimr.pethealthy.pethealthybackend.service.exception;

public class ConstraintViolationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ConstraintViolationException(String msg) {
        super(msg);
    }

    /**
     * @param message
     * @param cause
     */
    public ConstraintViolationException(String message, Throwable cause) {
        super(message, cause);
    }


}
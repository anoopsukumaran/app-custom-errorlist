package org.app.custom.errorlist.exception;

import lombok.Data;

import java.util.List;

@Data
public class CustomException extends Exception {

    private String message;
    private Integer statusCode;
    private ErrorResponse errorResponse;

    /**
     *
     * @param code
     * @param message
     * @param errorList
     */
    public CustomException(int code, String message, List<ErrorMessage> errorList) {
        this.statusCode = code;
        this.message = message;
        errorResponse = new ErrorResponse(code, message, errorList);
    }

}

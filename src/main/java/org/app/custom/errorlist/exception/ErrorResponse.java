package org.app.custom.errorlist.exception;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {

    private int code;
    private String message;
    private List<ErrorMessage> errors;

    /**
     *
     * @param code
     * @param message
     * @param errors
     */
    public ErrorResponse(int code, String message, List<ErrorMessage> errors) {
        super();
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

}

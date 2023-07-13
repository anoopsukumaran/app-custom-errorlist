package org.app.custom.errorlist.exception;

import lombok.Data;

@Data
public class ErrorMessage {
    private int code;
    private String message;
}

package org.app.custom.errorlist.exception;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExceptionHelper {

    /**
     *
     * @param code
     * @param message
     * @param errorMessageList
     * @throws CustomException
     */
    public void handleCustomException(int code, String message, List<ErrorMessage> errorMessageList) throws CustomException {
        throw new CustomException(code, message, errorMessageList);
    }

}

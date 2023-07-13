package org.app.custom.errorlist.validation;

import lombok.extern.log4j.Log4j2;
import org.app.custom.errorlist.exception.CustomException;
import org.app.custom.errorlist.exception.ErrorMessage;
import org.app.custom.errorlist.exception.ExceptionHelper;
import org.app.custom.errorlist.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class CommonValidator {

    @Autowired
    ExceptionHelper exceptionHelper;

    public void validateStudentInfo(Student student) throws CustomException {
        List<ErrorMessage> errorMessageList = new ArrayList<>();
        log.info("Checking Roll Number ... .. .");
        if(student!=null && student.getRollNo()==null || student.getRollNo().equalsIgnoreCase("string")) {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setCode(100);
            errorMessage.setMessage("Invalid Student Roll Number.");
            errorMessageList.add(errorMessage);
        }
        log.info("Checking Firstname ... .. .");
        if(student!=null && student.getFirstName()==null || student.getFirstName().equalsIgnoreCase("string")) {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setCode(101);
            errorMessage.setMessage("Firstname cannot be NULL or EMPTY.");
            errorMessageList.add(errorMessage);
        }
        log.info("Checking Lastname ... .. .");
        if(student!=null && student.getLastName()==null || student.getLastName().equalsIgnoreCase("string")) {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setCode(102);
            errorMessage.setMessage("Lastname cannot be NULL or EMPTY.");
            errorMessageList.add(errorMessage);
        }

        // If errorMessageList has any records invoke handleCustomException
        if(errorMessageList.size() > 0) {
            exceptionHelper.handleCustomException(400,"Business Exception",errorMessageList);
        }
    }

}

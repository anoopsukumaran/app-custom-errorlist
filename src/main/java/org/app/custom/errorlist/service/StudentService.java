package org.app.custom.errorlist.service;

import lombok.extern.log4j.Log4j2;
import org.app.custom.errorlist.exception.CustomException;
import org.app.custom.errorlist.model.Student;
import org.app.custom.errorlist.validation.CommonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
public class StudentService {

    @Autowired
    CommonValidator commonValidator;

    public Student createStudent(Student student) throws CustomException {
        commonValidator.validateStudentInfo(student);

        /* If above validation is successful create the student in the db
        *  Note : I am not writing the logic for that instead I am setting a random UUID as if
        *  it got generated after persisting in the database */
        student.setId(UUID.randomUUID().toString());
        log.info("UUID : {}", student.getId());
        return student;
    }

}

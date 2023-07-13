package org.app.custom.errorlist.controller;

import lombok.extern.log4j.Log4j2;
import org.app.custom.errorlist.exception.CustomException;
import org.app.custom.errorlist.model.Student;
import org.app.custom.errorlist.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/students")
@Log4j2
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) throws CustomException {
        log.info("Student Info : {}", student);
        Student resStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(resStudent);
    }

}

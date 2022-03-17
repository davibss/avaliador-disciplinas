package com.engSoft.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErroTeacher {

    static final String TEACHER_NOT_FOUND = "Teacher not found";


    public static ResponseEntity<CustomErrorType> erroTeacherNotFound() {
        return new ResponseEntity<CustomErrorType>(
                new CustomErrorType(ErroTeacher.TEACHER_NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}

package com.engSoft.controllers;

import com.engSoft.DTO.ReactionDTO;
import com.engSoft.entities.Reaction;
import com.engSoft.entities.Student;
import com.engSoft.services.ReactionService;
import com.engSoft.services.StudentService;
import com.engSoft.util.CustomErrorType;
import com.engSoft.util.ErroStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ReactionController {

    @Autowired
    StudentService studentService;

    @Autowired
    ReactionService reactionService;
    public ResponseEntity<?> createReaction(@RequestBody ReactionDTO feedbackDTO) {

        Optional<Student> optionalStudent = studentService.getStudentById(feedbackDTO.getIdStudent());

        if (!optionalStudent.isPresent()){
            return ErroStudent.erroStudentNotFound();
        }
        Reaction newReaction = new Reaction(feedbackDTO);
        try {
            reactionService.saveReaction(newReaction);
            return new ResponseEntity<String>("Reaction created! \n" + newReaction, HttpStatus.CREATED);
        }catch (Error e){
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Error, reaction can´t be created"), HttpStatus.NOT_FOUND);
        }
    }
}

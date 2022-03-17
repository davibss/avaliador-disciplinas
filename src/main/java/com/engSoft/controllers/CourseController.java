package com.engSoft.controllers;

import com.engSoft.DTO.CourseDTO;
import com.engSoft.entities.Course;
import com.engSoft.entities.Teacher;
import com.engSoft.services.CourseService;
import com.engSoft.services.TeacherService;
import com.engSoft.util.ErroCourse;
import com.engSoft.util.ErroTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/Course", method = RequestMethod.POST)
    public ResponseEntity<?> createCourse(@RequestBody CourseDTO courseDTO) {
        Optional<Teacher> optionalTeacher = teacherService.getTeacherByName(courseDTO.getNameTeacher());

        if (optionalTeacher.isPresent()) {
            Course newCourse = new Course(courseDTO, optionalTeacher.get().getId());
            courseService.saveCourse(newCourse);

            return new ResponseEntity<String>("Course succesfully created! \n" + newCourse, HttpStatus.CREATED);
        } else
            return ErroTeacher.erroTeacherNotFound();
    }

    @RequestMapping(value = "/CourseUpdate/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateCourse(@PathVariable("id") Long id, @RequestBody CourseDTO courseDTO) {
        Optional<Teacher> optionalTeacher = teacherService.getTeacherByName(courseDTO.getNameTeacher());

        if(!optionalTeacher.isPresent())
            return ErroTeacher.erroTeacherNotFound();

        Optional<Course> optionalCourse = courseService.findCourseById(id);

        if(optionalCourse.isPresent()) {
            optionalCourse.get().update(courseDTO, optionalTeacher.get().getId());
            courseService.saveCourse(optionalCourse.get());

            return new ResponseEntity<String>("Course succesfully updated! \n" + optionalCourse, HttpStatus.CREATED);
        } else
            return ErroCourse.erroCourseNotFound();
    }

    @RequestMapping(value = "/Courses", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCourses(){
        List<String> courses = this.courseService.listCourses();
        return new ResponseEntity<String>("Ok! \n" + courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/Courses/name", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCoursesSortName(){
        List<String> courses = this.courseService.listCoursesSortName();
        return new ResponseEntity<String>("Ok! \n" + courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/Courses/semester", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCoursesSortSemester(){
        List<String> courses = this.courseService.listCoursesSortSemester();
        return new ResponseEntity<String>("Ok! \n" + courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/Courses/grade", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCoursesSortGrade(){
        List<String> courses = this.courseService.listCoursesSortGrade();
        return new ResponseEntity<String>("Ok! \n" + courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/CoursesTeacher/{nameTeacher}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCoursesfromTeacher(@PathVariable("nameTeacher") String nameTeacher){
        Optional<Teacher> optionalTeacher = teacherService.getTeacherByName(nameTeacher);

        if (optionalTeacher.isPresent()) {
            List<Course> courses = this.courseService.listCoursesTeacher(optionalTeacher.get().getId());
            return new ResponseEntity<String>("Ok! \n" + courses, HttpStatus.OK);
        } else
            return ErroTeacher.erroTeacherNotFound();
    }

    @RequestMapping(value = "/Courses/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCourse(@PathVariable("id") Long id){
        Optional<Course> optionalCourse = courseService.findCourseById(id);

        if(optionalCourse.isPresent())
            return new ResponseEntity<String>("Course found! \n" + optionalCourse, HttpStatus.ACCEPTED);
        else
            return ErroCourse.erroCourseNotFound();
    }

    @RequestMapping(value = "CourseDelete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeCourse(@PathVariable ("id") Long id){
        Optional<Course> optionalCourse = courseService.findCourseById(id);

        if(optionalCourse.isPresent()) {
            courseService.removeCourse(optionalCourse.get());
            return new ResponseEntity<String>("Course succesfully deleted \n" + optionalCourse, HttpStatus.OK);
        } else
            return ErroCourse.erroCourseNotFound();
    }
}

package com.engSoft.controllers;

import com.engSoft.DTO.CourseDTO;
import com.engSoft.DTO.ReturnCourseDTO;
import com.engSoft.entities.Course;
import com.engSoft.entities.Teacher;
import com.engSoft.services.CommentService;
import com.engSoft.services.CourseService;
import com.engSoft.services.FeedbackService;
import com.engSoft.services.TeacherService;
import com.engSoft.util.ErroCourse;
import com.engSoft.util.ErroTeacher;
import com.engSoft.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @Autowired
    CommentService commentService;

    @Autowired
    FeedbackService feedbackService;

    @RequestMapping(value = "/admin/course", method = RequestMethod.POST)
    public ResponseEntity<?> createCourse(@RequestBody CourseDTO courseDTO) {
        Optional<Teacher> optionalTeacher = teacherService.getTeacherByName(courseDTO.getNameTeacher());

        if (optionalTeacher.isPresent()) {
            Course newCourse = new Course(courseDTO, optionalTeacher.get());
            courseService.saveCourse(newCourse);

            return new ResponseEntity<>(new ReturnCourseDTO(newCourse), HttpStatus.CREATED);
        } else
            return ErroTeacher.erroTeacherNotFound();
    }

    @RequestMapping(value = "/admin/courseUpdate/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateCourse(@PathVariable("id") Long id, @RequestBody CourseDTO courseDTO) {
        Optional<Teacher> optionalTeacher = teacherService.getTeacherByName(courseDTO.getNameTeacher());

        if(!optionalTeacher.isPresent())
            return ErroTeacher.erroTeacherNotFound();

        Optional<Course> optionalCourse = courseService.findCourseById(id);

        if(optionalCourse.isPresent()) {
            optionalCourse.get().setName(courseDTO.getName());
            optionalCourse.get().setCode(courseDTO.getCode());
            optionalCourse.get().setTeacher(optionalTeacher.get());
            courseService.saveCourse(optionalCourse.get());

            return new ResponseEntity<>(new ReturnCourseDTO(optionalCourse.get()), HttpStatus.OK);
        } else
            return ErroCourse.erroCourseNotFound();
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCourses(){
        List<Course> courses = this.courseService.listCourses();
        return new ResponseEntity<>(listToReturnCourse(courses), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/courses/{filter}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCoursesFilter(@PathVariable("filter") Util.FilterEnum filter){
        List<Course> courses = this.courseService.listCoursesFilter(filter);
        return new ResponseEntity<>(listToReturnCourse(courses), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/coursesTeacher/{nameTeacher}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCoursesFromTeacher(@PathVariable("nameTeacher") String nameTeacher){
        Optional<Teacher> optionalTeacher = teacherService.getTeacherByName(nameTeacher);

        if (optionalTeacher.isPresent()) {
            List<Course> courses = this.courseService.listCoursesTeacher(optionalTeacher.get());
            return new ResponseEntity<>(courses, HttpStatus.ACCEPTED);
        } else
            return ErroTeacher.erroTeacherNotFound();
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCourse(@PathVariable("id") Long id){
        Optional<Course> optionalCourse = courseService.findCourseById(id);

        if(optionalCourse.isPresent())
            return new ResponseEntity<>(new ReturnCourseDTO(optionalCourse.get()), HttpStatus.ACCEPTED);
        else
            return ErroCourse.erroCourseNotFound();
    }

    @RequestMapping(value = "/admin/courseDelete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeCourse(@PathVariable ("id") Long id){
        Optional<Course> optionalCourse = courseService.findCourseById(id);

        if(optionalCourse.isPresent()) {
            courseService.removeCourse(optionalCourse.get());
            return new ResponseEntity<>(new ReturnCourseDTO(optionalCourse.get()), HttpStatus.OK);
        } else
            return ErroCourse.erroCourseNotFound();
    }

    private List<ReturnCourseDTO> listToReturnCourse(List<Course> list) {
        List<ReturnCourseDTO> returnList = new ArrayList<>();
        for(Course course : list) {
            returnList.add(new ReturnCourseDTO(course));
        }
        return returnList;
    }
}

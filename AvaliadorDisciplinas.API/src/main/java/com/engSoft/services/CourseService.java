package com.engSoft.services;

import com.engSoft.entities.Course;
import com.engSoft.entities.Feedback;
import com.engSoft.entities.Teacher;
import com.engSoft.util.Util;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    void saveCourse(Course course);
    List<Course> listCourses();
    List<Course> listCoursesFilter(Util.FilterEnum filter);
    List<Course> listCoursesTeacher(Teacher teacher);
    void removeCourse(Course course);
    void updateGrade(Course course, List<Feedback> feedback);
    Optional<Course> findCourseById(Long id);
}

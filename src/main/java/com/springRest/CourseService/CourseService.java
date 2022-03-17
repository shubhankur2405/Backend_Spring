package com.springRest.CourseService;

import com.springRest.entities.Course;

import java.util.List;

public abstract class CourseService {
    public abstract List<Course>getCourses();

    public abstract Course getCourse(long courseID);

    public abstract Course addCourse(Course course);

    public abstract Course updateCourse(Course course);

    public abstract void deleteCourse(long parseLong);
}

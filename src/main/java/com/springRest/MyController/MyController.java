package com.springRest.MyController;

import com.springRest.CourseService.CourseService;
import com.springRest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseServicess;

     @GetMapping("/home")

    public String home(){

         return "Welcome to Courses Application";
     }

     //get the courses
    @GetMapping("/courses")
    public List<Course>getCourses(){

        return  this.courseServicess.getCourses();

    }

     @GetMapping("/courses/{courseID}")
    public Course getCourse(@PathVariable String courseID){

         return this.courseServicess.getCourse(Long.parseLong(courseID));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
         return this.courseServicess.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
         return this.courseServicess.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseID}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseID){
         try{
             this.courseServicess.deleteCourse(Long.parseLong(courseID));
             return new ResponseEntity<>(HttpStatus.OK);
         }catch (Exception e){
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }
}

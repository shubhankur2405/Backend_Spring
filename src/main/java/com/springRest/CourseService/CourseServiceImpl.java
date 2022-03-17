package com.springRest.CourseService;

import com.springRest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseServiceImpl extends CourseService {

    List<Course>list;

    public CourseServiceImpl(){

        list =new ArrayList<>();

        list.add(new Course(145,"Java Core Course","This Cousre is best"));
        list.add(new Course(4343,"spring boot ","very nice tutotrial"));
    }


    @Override
    public List<Course>getCourses(){
        return list;
    }

    @Override
    public Course getCourse(long courseID) {

        Course c = null;
        for(Course course:list){

            if(course.getId()==courseID){
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
            list.forEach(e->{
                if(e.getId()==course.getId()){
                    e.setTitle(course.getTitle());
                    e.setDescription(course.getDescription());
                }
            });

        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
        list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
    }

}

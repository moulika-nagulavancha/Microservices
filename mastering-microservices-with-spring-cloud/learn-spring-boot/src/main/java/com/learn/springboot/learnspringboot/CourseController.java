package com.learn.springboot.learnspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn Spring Boot", "Moulika"),
                new Course(2, "Learn AWS", "Sai Siddhartha"),
                new Course(3, "Learn Angular", "Ravalika"),
                new Course(4, "Learn JavaScript", "Adheera Regonda"),
                new Course(5, "Learn Advanced Java Programming", "Belinda Copus")
        );
    }
}

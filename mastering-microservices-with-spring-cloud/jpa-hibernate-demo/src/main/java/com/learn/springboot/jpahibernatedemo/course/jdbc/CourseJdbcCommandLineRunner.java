package com.learn.springboot.jpahibernatedemo.course.jdbc;

import com.learn.springboot.jpahibernatedemo.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS", "Belinda Copus"));
        repository.insert(new Course(2, "Learn Azure", "Belinda Copus"));
        repository.insert(new Course(3, "Learn Angular", "Belinda Copus"));
        repository.insert(new Course(4, "Learn Java", "Belinda Copus"));

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}

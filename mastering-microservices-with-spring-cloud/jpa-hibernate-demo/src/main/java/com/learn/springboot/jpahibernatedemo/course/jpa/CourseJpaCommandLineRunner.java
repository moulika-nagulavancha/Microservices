package com.learn.springboot.jpahibernatedemo.course.jpa;

import com.learn.springboot.jpahibernatedemo.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS JPA", "Belinda Copus"));
        repository.insert(new Course(2, "Learn Azure JPA", "Belinda Copus"));
        repository.insert(new Course(3, "Learn Angular JPA", "Belinda Copus"));
        repository.insert(new Course(4, "Learn Java JPA", "Belinda Copus"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}

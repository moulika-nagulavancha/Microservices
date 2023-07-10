package com.learn.springboot.jpahibernatedemo.course.springdatajpa;

import com.learn.springboot.jpahibernatedemo.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSpringDataJpaCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS Data JPA", "Belinda Copus"));
        repository.save(new Course(2, "Learn Azure Data JPA", "Belinda Copus"));
        repository.save(new Course(3, "Learn Angular Data JPA", "Belinda Copus"));
        repository.save(new Course(4, "Learn Java Data JPA", "Belinda Copus"));

        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("Belinda Copus"));
    }
}

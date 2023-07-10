package com.learn.springboot.jpahibernatedemo.course.springdatajpa;

import com.learn.springboot.jpahibernatedemo.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    public List<Course> findByAuthor(String author);
}

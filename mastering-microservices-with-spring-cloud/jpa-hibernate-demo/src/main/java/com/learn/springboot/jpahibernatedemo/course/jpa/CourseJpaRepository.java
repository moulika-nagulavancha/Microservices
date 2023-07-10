package com.learn.springboot.jpahibernatedemo.course.jpa;

import com.learn.springboot.jpahibernatedemo.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    // instead of autowired we can use more specific context based annotation here
    @PersistenceContext
    private EntityManager entityManager;
    public void insert(Course course) {
        entityManager.merge(course);
    }
    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }
    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}

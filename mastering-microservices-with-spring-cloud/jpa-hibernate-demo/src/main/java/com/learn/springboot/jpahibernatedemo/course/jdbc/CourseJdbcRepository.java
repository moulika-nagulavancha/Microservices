package com.learn.springboot.jpahibernatedemo.course.jdbc;

import com.learn.springboot.jpahibernatedemo.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static String INSERT_QUERY =
            """
                insert into course(id, name, author) 
                    values(?, ?, ?);
            """;
    private static String SELECT_QUERY =
            """
                select * from course where id=?;
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public Course findById(long id) {
        // map each row in the result set to a bean
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), id);
    }
}

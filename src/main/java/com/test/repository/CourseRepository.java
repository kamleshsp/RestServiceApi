package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}

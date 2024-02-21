/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.data.jpa.repository.JpaRepository;
 * import org.springframework.stereotype.Repository;
 * 
 */

// Write your code here
package com.example.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.university.model.*;
import java.util.*;

@Repository
public interface CourseJpaRepository extends JpaRepository<Course, Integer> {
    List<Course> findByStudent(Student student);
}
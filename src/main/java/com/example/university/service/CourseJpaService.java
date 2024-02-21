/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import com.example.university.model.*;
import com.example.university.repository.*;

import java.util.NoSuchElementException;

@Service
public class CourseJpaService implements CourseRepository {
	@Autowired
	private CourseJpaRepository courseJpaRepository;

	@Autowired
	private ProfessorJpaRepository professorJpaRepository;

	@Autowired
	private StudentJpaRepository studentJpaRepository;

	@Override
	public ArrayList<Course> getCources() {
		List<Course> courseList = courseJpaRepository.findAll();
		ArrayList<Course> cources = new ArrayList<>(courseList);
		return cources;
	}

	@Override
	public Course getCourseById(int courseId) {
		try {
			Course course = courseJpaRepository.findById(courseId).get();
			return course;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Course addCourse(Course course) {
		List<Integer> studentIds = new ArrayList<>();
		for (Student student : course.getStudents()) {
			studentIds.add(student.getStudentId());
		}
		Professor professor = course.getProfessor();
		int professorId = professor.getProfessorId();

		try {
			List<Student> completeStudents = studentJpaRepository.findAllById(studentIds);
			if (studentIds.size() != completeStudents.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
			professor = professorJpaRepository.findById(professorId).get();
			course.setProfessor(professor);
			courseJpaRepository.save(course);
			return course;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Course updateCourse(int courseId, Course course) {
		try {
			Course newCourse = courseJpaRepository.findById(courseId).get();
			if (course.getCourseName() != null) {
				newCourse.setCourseName(course.getCourseName());
			}
			if (course.getCredits() != null) {
				newCourse.setCredits(course.getCredits());
			}
			if (course.getProfessor() != null) {
				Professor professor = course.getProfessor();
				int professorId = professor.getProfessorId();
				Professor newProfessor = professorJpaRepository.findById(professorId).get();
				newCourse.setProfessor(newProfessor);
			}
			courseJpaRepository.save(newCourse);
			return newCourse;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteCourse(int courseId) {
		try {
			courseJpaRepository.deleteById(courseId);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}

	@Override
	public Professor getCourseProfessor(int courseId) {
		try {
			Course course = courseJpaRepository.findById(courseId).get();
			return course.getProfessor();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Student> getCourseStudents(int courseId) {
		try {
			Course course = courseJpaRepository.findById(courseId).get();
			return course.getStudents();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
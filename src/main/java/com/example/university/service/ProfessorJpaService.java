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
import com.example.university.repository.*;

@Service
public class ProfessorJpaService implements ProfessorRepository {
	@Autowired
	private ProfessorJpaRepository professorJpaRepository;

	@Override
	public ArrayList<Professor> getProfessors() {
		List<Professor> professorList = professorJpaRepository.findAll();

	}

	@Override
	public Professor getProfessorById(int professorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor updateProfessor(int professorId, Professor professor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProfessor(int professorId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Course getProfessorCourse(int professorId) {
		// TODO Auto-generated method stub
		return null;
	}
}
/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.university.repository;

import com.example.university.model.*;
import java.util.*;

public interface ProfessorRepository {
    ArrayList<Professor> getProfessors();

    Professor getProfessorById(int professorId);

    Professor addProfessor(Professor professor);

    Professor updateProfessor(int professorId, Professor professor);

    void deleteProfessor(int professorId);

    Course getProfessorCourse(int professorId);

}
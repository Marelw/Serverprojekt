package se.yrgo.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import se.yrgo.dataaccess.StudentDataAccess;
import se.yrgo.domain.Student;

/** Injects into the dataaccess for the Get methods */
@Stateless
public class StudentManagementImplementation implements StudentManagementService {
	@Inject
	private StudentDataAccess dao;

	@Override
	public void registerStudent(Student student) {
		dao.insert(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return dao.findAll();
	}

	@Override
	public List<Student> searchBysurname(String surname) {
		return dao.findBySurname(surname);
	}

	@Override
	public Student getById(int id) {
		return dao.findById(id);
	}
}
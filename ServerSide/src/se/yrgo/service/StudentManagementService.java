package se.yrgo.service;

import java.util.List;

import javax.ejb.Local;

import se.yrgo.domain.Student;

/** Interface for the ManagementImplementation */
@Local
public interface StudentManagementService {
	
	public void registerStudent(Student student);
	public List<Student>getAllStudents ();
	public List<Student>searchBysurname(String surname);
	public Student getById(int id);

}

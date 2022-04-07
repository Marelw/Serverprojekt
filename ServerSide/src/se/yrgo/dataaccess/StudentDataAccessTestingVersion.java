package se.yrgo.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import se.yrgo.domain.Student;

@Stateless
@Alternative
public class StudentDataAccessTestingVersion implements StudentDataAccess {

	public void insert(Student newStudent) {
	}

	public List<Student> findAll() {
		Student std1 = new Student("Nahid", "V", "Game Design Creator", 2);
		Student std2 = new Student("Sara", "Bild", "UX-design", 2);
		Student std3 = new Student("David", "Baron", "Java Enterprise Development", 1);
		List<Student> student = new ArrayList<>();
		student.add(std1);
		student.add(std2);
		student.add(std3);
		return student;
	}

	public List<Student> findBySurname(String surname) {
		return null;
	}

	@Override
	public Student findById(int id) {
		return null;
	}
}

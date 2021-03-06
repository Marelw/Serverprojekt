package se.yrgo.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import se.yrgo.domain.Student;

/** Actual methods that are being used for getting the students */
@Stateless
@Default
public class StudentDataAccessProductionVersion implements StudentDataAccess {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insert(Student newStudent) {
		em.persist(newStudent);
	}

	@Override
	public List<Student> findAll() {
		Query q = em.createQuery("select student from Student student");
		List<Student> student = q.getResultList();
		return student;
	}

	@Override
	public List<Student> findBySurname(String surname) {
		Query q = em.createQuery("select student from Student student where student.surname = :surname");
		q.setParameter("surname", surname);
		return q.getResultList();
	}

	@Override
	public Student findById(int id) {
		Query q = em.createQuery("select student from Student student where student.id = :id");
		q.setParameter("id", id);
		return (Student) q.getSingleResult();
	}

}

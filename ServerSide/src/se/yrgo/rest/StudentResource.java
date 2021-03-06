package se.yrgo.rest;

import java.util.List;

import javax.ejb.Stateless;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import se.yrgo.domain.Student;
import se.yrgo.service.StudentManagementService;

/**Return the get methods as JSON text */
@Stateless
@Path("/students")
public class StudentResource {
	@Inject
	private StudentManagementService service;

	@GET
	@Produces("application/JSON")
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}

	@GET
	@Produces("application/JSON")
	@Path("{studentNo}")
	public Student findStudentsById(@PathParam("studentNo") int id) {
		return service.getById(id);
	}

	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Student createStudent(Student student) {
		service.registerStudent(student);
		return student;
	}

}

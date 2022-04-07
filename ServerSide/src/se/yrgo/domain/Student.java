package se.yrgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**Constructor for students, getters and setters for all fields. */
@Entity
public class Student implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String surname;
	private String course;
	private int yearGroup;

	public Student() {

	}

	public Student(String firstName, String surname, String course, int yearGroup) {
		this.firstName = firstName;
		this.surname = surname;
		this.course = course;
		this.yearGroup = yearGroup;
	}

	//#region
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getYearGroup() {
		return yearGroup;
	}
	
	public void setYearGroup(int yearGroup) {
		this.yearGroup = yearGroup;
	}

//#endregion


	public String toString() {
		return "Student: " + this.firstName + " " + this.surname;
	}
}

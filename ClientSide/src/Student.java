/* Getters and setters for the Students that are created */
public class Student {

	private int id;
	private String firstName;
	private String surname;
	private String course;
	private int yearGroup;

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
		return "Student (" + this.id + ") - " + this.firstName + " " + this.surname;
	}
}
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class TestClient {

	/*Mainmethod that posts 1 student and gets all student from the database*/	
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Student std = new Student();
		std.setFirstName("Andreas");
		std.setSurname("Karlsson");
		std.setCourse("Java");
		std.setYearGroup(0);

		Entity stdEntity = Entity.entity(std, "application/JSON");

		Response response = client.target("http://localhost:8080/StudentManagement/webservice/students").request()
				.buildPost(stdEntity).invoke();

		System.out.println(response.readEntity(Student.class).getId());
		response.close();

		response = client.target("http://localhost:8080/StudentManagement/webservice/students").request().buildGet()
				.invoke();
		List<Student> students = response.readEntity(new GenericType<List<Student>>() {
		});

		for (Student s : students) {
			System.out.println(s);
		}
		response.close();
	}

	

}

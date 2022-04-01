import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class TestClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Student ben = new Student();
		ben.setFirstName("Ben");
		ben.setSurname("Red");
		ben.setCourse("UX-Design");
		ben.setYearGroup(1);

		Entity benEntity = Entity.entity(ben, "application/JSON");

		Response response = client.target("http://localhost:8080/StudentManagement/webservice/students").request()
				.buildPost(benEntity).invoke();

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

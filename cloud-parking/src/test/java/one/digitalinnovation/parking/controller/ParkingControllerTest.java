package one.digitalinnovation.parking.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import io.restassured.RestAssured;
import one.digitalinnovation.parking.controller.dto.ParkingCreateDTO;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ParkingControllerTest {
	
	@LocalServerPort
	private int randomPort;
	
	@BeforeEach
	public void setupTest()
	{
		System.out.println(randomPort);
		
		RestAssured.port = randomPort;
	}
	
	@Test
	void whenFindAllCheckResult()
	{
		RestAssured.given().when().get("/parking").then().statusCode(200).body("license", Matchers.hasItem("VVV-1111"));
	}
	
	@Test
	void whenCreateThenCheckIsCreate()
	{
		var createDTO = new ParkingCreateDTO();
		createDTO.setColor("AMARELA");
		createDTO.setLicense("KKK-6666");
		createDTO.setModel("FUSCA");
		createDTO.setState("RJ");
		
		RestAssured.given()
					.when()
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.body(createDTO)
					.post("/parking")
					.then()
					.statusCode(HttpStatus.CREATED.value())
					//.get("/parking")
					.body("license", Matchers.equalTo("KKK-6666"))
					.body("color", Matchers.equalTo("AMARELA"));
	}

}

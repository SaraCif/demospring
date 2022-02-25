package com.spring.demospring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class DemoSpringApplicationTests {

	MockMvc mock;

	HttpHeaders headers;
	
	@BeforeEach
	void setup(WebApplicationContext wac) {
		this.mock = MockMvcBuilders.webAppContextSetup(wac).build();
		this.headers = new HttpHeaders();
		/*List<MediaType> mediaTypeAccepted = new ArrayList<>();
		mediaTypeAccepted.add(MediaType.APPLICATION_JSON);
		this.headers.setAccept(mediaTypeAccepted);*/
		this.headers.setContentType(MediaType.APPLICATION_JSON);
	}

	@Test
	@Order(1)
	public void searchUser() throws Exception {
		
		mock.perform(
				get("/searchUser")
				.queryParam("name", "sara")
				.headers(headers)
				)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$[0].name").value("Sara"));

	}
	
	@Test
	@Order(2)
	public void createUser() throws Exception {
		mock.perform(
				post("/user")
				.content("{\r\n"
						+ "	\"id\": 99,\r\n"
						+ "	\"name\": \"NomeProva\",\r\n"
						+ "	\"surname\": \"Cognome\",\r\n"
						+ "	\"email\": \"nome.cognome@gmail.com\",\r\n"
						+ "	\"password\": \"demo\",\r\n"
						+ "	\"address\": \"via\"\r\n"
						+ "}\r\n"
						+ "")
				.headers(headers))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.code").value(0))
		;

	}
	
	@Test
	@Order(3)
	public void updateUser() throws Exception {
		
		mock.perform(
				put("/user/99")
				.content("{\r\n"
						+ "	\"id\": 99,\r\n"
						+ "	\"name\": \"NomeProva\",\r\n"
						+ "	\"surname\": \"Cognome\",\r\n"
						+ "	\"email\": \"nome.cognome@gmail.com\",\r\n"
						+ "	\"password\": \"demo\",\r\n"
						+ "	\"address\": null\r\n"
						+ "}\r\n"
						+ "")
				.headers(headers)
				)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.code").value(0));

	}
	
	@Test
	@Order(4)
	public void getUserById() throws Exception {
		
		mock.perform(
				get("/user/99")
				.headers(headers)
				)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(99));

	}
	
	@Test
	@Order(5)
	public void deleteUser() throws Exception {
		
		mock.perform(
				delete("/user/99")
				.headers(headers)
				)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.code").value(0));

	}

}

package com.expd.training.week11.employee;

import com.expd.training.week11.employee.model.HourlyEmployee;
import com.expd.training.week11.employee.service.HourlyEmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Tag("integration")
class EmployeeApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private HourlyEmployeeService hourlyEmployeeService;

	private String baseUrl;

	@BeforeEach
	void setUp() {
		baseUrl = "http://localhost:" + port + "/employee";
	}
	@Test
	void testGetAllHourlyEmployee() {
		baseUrl+="/hourly";
		ResponseEntity<HourlyEmployee[]> response = restTemplate.getForEntity(baseUrl, HourlyEmployee[].class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
	}

	@Test
	void testGetAllSalariedEmployee() {
		baseUrl+="/salaried";
		ResponseEntity<HourlyEmployee[]> response = restTemplate.getForEntity(baseUrl, HourlyEmployee[].class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
	}


}

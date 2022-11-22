package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.Employee;
import org.ssglobal.training.codes.EmployeeRepository;

public class TestEmployeeRepository {
	private EmployeeRepository empRepo;
	
	@BeforeEach
	public void setup() {
		Employee emp1 = new Employee(101, "Maria", "Mercedez", 35000.00);
		Employee emp2 = new Employee(102, "Mario", "Merzo", 35000.00);
		List<Employee> emptbl = Arrays.asList(emp1, emp2);
		empRepo = new EmployeeRepository(emptbl);
	}
	
	@AfterEach
	public void teardown() {
		empRepo = null;
	}
	
	@Test
	public void testGetEmployees() {
		List<Employee> actualRec = empRepo.getEmployees();
		List<String> expectedListNames = Arrays.asList("Maria", "Mario");
		double expectedAvgSalary = 35000.00;
		
		assertAll(
			() -> {
				assertIterableEquals(expectedListNames, actualRec.stream().map((rec) -> {
					return rec.fname();
				}).collect(Collectors.toList()));
			},
			() -> {
				assertEquals(expectedAvgSalary, actualRec.stream().map((rec) -> {
					return rec.salary();
				}).mapToDouble(Double::doubleValue).average().getAsDouble());
			}
		);
		
		
	}
	
	
	
	
	
	
}

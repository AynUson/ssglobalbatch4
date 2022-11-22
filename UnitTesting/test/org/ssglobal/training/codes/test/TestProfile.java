package org.ssglobal.training.codes.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.Profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProfile {
//	Setup and initialization
	private Profile p1;

	
	@BeforeAll
	public static void superSetup() {
	System.out.println("Super Setup");	
	}
	
	@AfterAll
	public static void superTeardown() {
		System.out.println("Super Teardown");	
		
	}
	
	@BeforeEach
	public void setup() {
		p1 = new Profile("Juan", 90);
	}
	
	
	@AfterEach
	public void teardown() {
		p1 = null;
		
	}
	
	
	
	//	test cases in the for of methods
	@Test
	public void testShowProfile() {
		String exepectedRec = "Juan 90";
		String actualRec = p1.showProfile();
		assertEquals(exepectedRec, actualRec);
//		Profile p1 = new Profile("Ayn", 18); WRONG XXXXXXX
		System.out.println("method 1");
		System.out.println(p1.showProfile());
		
	}
	
	
	@Test
	public void testIncreaseAge() {
		int exepectedRec = 20;
		int actualRec = p1.increaseAge(10);
		assertEquals(exepectedRec, actualRec);
		System.out.println("method 2");
		int newAge = p1.increaseAge(3);
		System.out.println(newAge);
		System.out.println(p1.showProfile());
		
	}

}

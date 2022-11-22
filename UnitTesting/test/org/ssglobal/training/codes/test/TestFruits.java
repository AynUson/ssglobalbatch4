package org.ssglobal.training.codes.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.ssglobal.training.codes.Fruits;

//import static org.junit.jupiter

public class TestFruits {
	
	
	private Fruits fruits;
	
	@BeforeEach
	public void setup() {
		fruits = new Fruits();
	}
	
	@AfterEach
	public void teardown() {
		fruits = null;
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Apple", "Mango", "Guava"})
	public void testAddFruits(String param) {
		System.out.println(1);
		boolean actualRes = fruits.addFruits(param);
		assertEquals(true, actualRes);
	}

	@Test
	public void testAddFruitsRainy() {
		System.out.println(2);
		boolean actualRes = fruits.addFruits("Apple", "Mango");
		assertNotEquals(true, actualRes);
	}

	@Test
	public void testGetStandNotNull() {
		System.out.println(3);
		assertNotNull(fruits.getStand());
		
	}

	@Test
	public void testGetStandContent() {

		System.out.println(4);
		List<String> expectedStand = Arrays.asList("Apple", "Mango");
		List<String> actualStand = fruits.getStand();
		assertIterableEquals(expectedStand, actualStand);
		
	}

	@Test
	public void testCountStand() {
		assertTimeout(Duration.ofMillis(50), () -> {
			int expectFruits = 10;
			int actualFruits = fruits.countFruits();
			assertTrue(actualFruits >= expectFruits);
		});
		
	}

	@Test
	public void testStandString() {
		System.out.println(6);
		Stream<String> expectedStrStreamo = Stream.of("Mango", "Apple");
		Stream<String> actualStrStreamo = fruits.getFruitStream();
		
		assertLinesMatch(expectedStrStreamo, actualStrStreamo);
	}
	
	
	
}

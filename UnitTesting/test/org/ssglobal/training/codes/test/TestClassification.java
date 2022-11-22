package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.ssglobal.training.codes.Classification;

public class TestClassification {

	private Classification classification;
	
	@BeforeEach
	public void setup() {
		classification = Classification.EXCELLENT;
	}
	
	@AfterEach
	public void teardown() {
		classification = null;
	}
	
	@Test
	public void testEvaluate() {
		Classification actualRes = Classification.evaluate(79);
		Classification expectedRes = Classification.PASS;
		assertSame(expectedRes, actualRes);
		
	}
	
	@ParameterizedTest
	@EnumSource(Classification.class)
	public void testGetWeights(Classification rate) {
		double expectedValue = 60;
		double actualValue = Classification.computeWeights(rate);
		assertFalse(actualValue >= expectedValue);
	}
	
	
	
	
	
}

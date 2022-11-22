package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.ssglobal.training.codes.MathOp;

public class TestMathOp {

	private MathOp mop;
	
	
	@BeforeEach
	public void setup() {
		mop = new MathOp();
	}
	
	@AfterEach
	public void teardown() {
		mop = null;
	}
	
	@ParameterizedTest
	@ValueSource(ints = {0,1,2,3,-4,5,-6,7,-8,9,10})
	public void testDivide(int param) {
		int expectedValue = 0;
		try {
			int actualValue = mop.divide(10, param);
			assertEquals(expectedValue, actualValue);
		}catch(Exception e) {
			fail("did not apply try-catch");
		}
	}

	@ParameterizedTest
	@MethodSource("createParams")
	public void testDivideTwoParams(DivideParams param) {
		int expectedValue = 0;
		try {
			int actualValue = mop.divide(param.getxParam(), param.getyParam());
			assertEquals(expectedValue, actualValue);
		}catch(Exception e) {
			fail("did not apply try-catch");
		}
	}
	
	@Test
	public void testDivideNew() {
		int expectedValue = 10;
		assertDoesNotThrow(() -> {
			int actualValue = mop.divide(10, 0);
			assertEquals(expectedValue, actualValue);
		}, "did not apply try-catch");
	}
	

	public static Stream<DivideParams> createParams (){
		return Stream.of(new DivideParams(10, 10), new DivideParams(6, 3), new DivideParams(-3, 0), new DivideParams(3, -5));
	}
	
}

class DivideParams{
	private int xParam;
	private int yParam;
	
	public DivideParams(int xParam, int yParam) {
		this.xParam = xParam;
		this.yParam = yParam;
	}
	
	
	public int getxParam() {
		return xParam;
	}
	public void setxParam(int xParam) {
		this.xParam = xParam;
	}
	public int getyParam() {
		return yParam;
	}
	public void setyParam(int yParam) {
		this.yParam = yParam;
	}
	
}	
















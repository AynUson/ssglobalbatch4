package org.ssglobal.training.codes;

public enum Classification {

	EXCELLENT,
	VERY_SATISFACTORY,
	SATISFACTORY,
	PASS,
	FAIL;
	
	public static Classification evaluate(double grade) {
		if(grade >= 95) {
			return EXCELLENT;
		}else if((grade >= 90) && (grade < 95)) {
			return VERY_SATISFACTORY;
		}else if((grade >= 80) && (grade < 90)) {
			return SATISFACTORY;
		}else if((grade >= 70) && (grade < 80)) {
			return PASS;
		}else {
			return FAIL;
		}
	}
	
	public static double computeWeights(Classification rate) {
		
		switch (rate) {
		case EXCELLENT:
			return 100.00;
		case VERY_SATISFACTORY:
			return 90.00;
		case SATISFACTORY:
			return 80.00;
		case PASS:
			return 70.00;
		default:
			return 50.00;
		}
		
	}
	
	
	
}

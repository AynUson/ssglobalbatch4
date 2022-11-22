package org.ssglobal.training.codes.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses(value = {TestFruits.class, TestMathOp.class, TestClassification.class}) // if selected test class only
@SelectPackages(value = {"org.ssglobal.training.codes.test"})
public class TestAllClasses {

}

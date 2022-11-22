package org.ssglobal.training.codes;

public class Profile {

	private String name;
	private Integer age;
	
	public Profile() {
		this.age = 18;
		this.name = "";
	}
	
	public Profile(String name, Integer age) {
		this.age = age;
		this.name = name;
	}
	
	public String showProfile() {
		return String.join(" ", name, String.valueOf(age));
	}
	
	public int increaseAge(int gradient) {
		this.age += gradient;
		return age;
	}
}

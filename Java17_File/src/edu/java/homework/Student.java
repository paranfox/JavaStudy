package edu.java.homework;

import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private String math;
	private String eng;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String math, String eng) {
		this.name = name;
		this.math = math;
		this.eng = eng;
	}

	public String displayInfo() {
		return "Student [name=" + name + ", math=" + math + ", eng=" + eng + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

}

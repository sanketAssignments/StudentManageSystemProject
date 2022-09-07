package com.stud.bean;

import java.util.List;

public class Student implements Comparable<Student> {
	private int rollno;
	private String studentName;
	private int age;
	private List<Address> address;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int rollno, String studentName, int age, List<Address> address) {
		super();
		this.rollno = rollno;
		this.studentName = studentName;
		this.age = age;
		this.address = address;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", studentName=" + studentName + ", age=" + age + ", address=" + address
				+ "]";
	}

	@Override
	public int compareTo(Student o) {
		if (this.rollno == o.rollno)
			return 0;
		if (this.rollno < o.rollno)
			return -1;
		else
			return 1;
	}

//	@Override
//	public int compareTo(Student o) {
//		if(this.rollno == o.rollno)
//			return 0;
//		if(this.rollno < o.rollno)
//			return -1;
//		else 
//			return 1;
//			
//		}
}

//	@Override
//	public int compareTo(Student o) {
//		if (this.rollno == o.rollno)
//			return 0;
//		if (this.rollno < o.rollno)
//			return -1;
//		else
//			return 1;
//	}

// @Override
//	public int compareTo(Student o) {
//		if (this.rollno == o.rollno)
//			return 0;
//		if (this.rollno < o.rollno)
//			return 1;
//		else
//			return 1;
//	}

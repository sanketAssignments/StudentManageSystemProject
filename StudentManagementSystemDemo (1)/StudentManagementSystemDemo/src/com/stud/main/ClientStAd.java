package com.stud.main;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.stud.bean.Address;
import com.stud.bean.Student;
import com.stud.util.DatamanagerImpl;

public class ClientStAd {
	public static void main(String[] args) {

		DatamanagerImpl dm = new DatamanagerImpl();
		Set<Student> stud = dm.populateData("student.txt", "address.txt");
		System.out.println(stud);

		System.out.println("\n" + "Sorted Data : ");
		Set<Student> students = dm.sortData(stud);
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("\n" + "Validate Date : ");
		Set<Student> s = dm.validateData(students);
		for (Student ss : students) {
			System.out.println(ss);
		}
	}

}

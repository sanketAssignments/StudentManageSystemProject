package com.stud.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.stud.bean.Address;
import com.stud.bean.Student;

public class DatamanagerImpl implements DataManager {

	@Override
	public Set<Student> populateData(String fileName, String addressfile) {
		Set<Student> sList = new HashSet<>();
		File f = new File(fileName);
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNext()) {
				String[] m = sc.nextLine().split(",");
				Student s = new Student(Integer.parseInt(m[0]), m[1], Integer.parseInt(m[2]), new ArrayList<>());
				sList.add(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Address> aList = new ArrayList<>();
		File f1 = new File(addressfile);
		try {
			Scanner sc1 = new Scanner(f1);
			while (sc1.hasNext()) {
				String[] m1 = sc1.nextLine().split(",");
				Address a = new Address(Integer.parseInt(m1[0]), m1[1], m1[2], m1[3]);
				aList.add(a);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Student s : sList) {
			for (Address a : aList) {
				if (s.getRollno() == a.getRollno()) {
					s.getAddress().add(a);
				}
			}
		}

		return sList;
	}

	@Override
	public Set<Student> sortData(Set<Student> set) {
		Set<Student> st = new TreeSet<>();
		st.addAll(set);

		return st;
	}

	@Override
	public Set<Student> validateData(Set<Student> set) {
		Iterator<Student> stu = set.iterator();
		while (stu.hasNext()) {
			Student s1 = stu.next();
			Iterator<Address> ad = s1.getAddress().iterator();
			while (ad.hasNext()) {
				Address a1 = ad.next();
				if (s1.getRollno() == 0 || s1.getStudentName().equals(null) || s1.getAge() == 0
						|| a1.getStreetName().equals(null) || a1.getCity().equals(null)
						|| a1.getZipCode().equals(null)) {
					stu.remove();
					ad.remove();
				}
			}
		}

		return set;
	}

}

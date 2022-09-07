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

//	@Override
//	public Set<Student> populateData(String fileName, String addressfile) {
//		Set<Student> sList = new HashSet<>();
//
//		File f = new File(fileName);
//		try {
//			Scanner sc = new Scanner(f);
//			while (sc.hasNext()) {
//				String st = sc.nextLine();
//				String[] m = st.split(",");
//				Student s = new Student(Integer.parseInt(m[0]), m[1], Integer.parseInt(m[2]), new ArrayList<>());
//				sList.add(s);
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<Address> aList = new ArrayList<>();
//		File f1 = new File(addressfile);
//		try {
//			Scanner sc1 = new Scanner(f1);
//			while (sc1.hasNext()) {
//				String st1 = sc1.nextLine();
//				String[] mm = st1.split(",");
//				Address a = new Address(Integer.parseInt(mm[0]), mm[1], mm[2], mm[3]);
//				aList.add(a);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (Student s : sList) {
//			for (Address a : aList) {
//				if (s.getRollno() == a.getRollno()) {
//					s.getAddress().add(a);
//				}
//			}
//		}
//
//		return sList;
//	}
//
//	@Override
//	public Set<Student> sortData(Set<Student> set) {
//		Set<Student> st = new TreeSet<>();
//		st.addAll(set);
//		return st;
//	}
//
//	@Override
//	public Set<Student> validateData(Set<Student> set) {
//		Iterator<Student> s = set.iterator();
//		while (s.hasNext()) {
//			Student s1 = s.next();
//			Iterator<Address> a = s1.getAddress().iterator();
//			while (a.hasNext()) {
//				Address ad = a.next();
//				if (s1.getRollno() == 0 || s1.getStudentName().equals(null) || s1.getAge() == 0
//						|| ad.getStreetName().equals(null) || ad.getCity().equals(null)
//						|| ad.getZipCode().equals(null)) {
//					s.remove();
//					a.remove();
//				}
//			}
//		}
//		return set;
//	}
//
//}

//	@Override
//	public Set<Student> populateData(String fileName, String addressfile) {
//		Set<Student> sList = new HashSet<>();
//
//		File f = new File(fileName);
//		try {
//			Scanner sc = new Scanner(f);
//			while (sc.hasNext()) {
//				String st = sc.nextLine();
//				String[] m = st.split(",");
//				Student s = new Student(Integer.parseInt(m[0]), m[1], Integer.parseInt(m[2]), new ArrayList<>());
//				sList.add(s);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<Address> aList = new ArrayList<>();
//		File f1 = new File(addressfile);
//		try {
//			Scanner sc1 = new Scanner(f1);
//			while (sc1.hasNext()) {
//				String st1 = sc1.nextLine();
//				String[] mm = st1.split(",");
//				Address a = new Address(Integer.parseInt(mm[0]), mm[1], mm[2], mm[3]);
//				aList.add(a);
//
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (Student s : sList) {
//			for (Address ab : aList) {
//				if (s.getRollno() == ab.getRollno()) {
//					s.getAddress().add(ab);
//				}
//
//			}
//		}
//
//		return sList;
//	}
//
//	@Override
//	public Set<Student> sortData(Set<Student> set) {
//		Set<Student> st = new TreeSet<>();
//		st.addAll(set);
//
//		return st;
//	}
//
//	@Override
//	public Set<Student> validateData(Set<Student> set) {
//		Iterator<Student> s = set.iterator();
//		while (s.hasNext()) {
//			Student s1 = s.next();
//			Iterator<Address> a = s1.getAddress().iterator();
//			while (a.hasNext()) {
//				Address ad = a.next();
//				if (s1.getRollno() == 0 || s1.getStudentName().equals(null) || s1.getAge() == 0 || s1.getAddress().equals(null)
//			|| ad.getRollno() == 0 || ad.getStreetName().equals(null) || ad.getCity().equals(null) || ad.getZipCode().equals(null)) {
//					s.remove();
//					a.remove();
//				}
//				
//			}
//		}
//		
//		
//		return set;
//	}
//
//}

//	@Override
//	public Set<Student> populateData(String fileName, String addressfile) {
//
//		Set<Student> sList = new HashSet<>();
//		File f = new File(fileName);
//		try {
//			Scanner sc = new Scanner(f);
//			while (sc.hasNext()) {
//				String st = sc.nextLine();
//				String[] m = st.split(",");
//				Student s = new Student(Integer.parseInt(m[0]), m[1], Integer.parseInt(m[2]), new ArrayList<>());
//				sList.add(s);
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<Address> aList = new ArrayList<>();
//		File f1 = new File(addressfile);
//		try {
//			Scanner sc1 = new Scanner(f1);
//			while (sc1.hasNext()) {
//				String st1 = sc1.nextLine();
//				String[] mm = st1.split(",");
//				Address a = new Address(Integer.parseInt(mm[0]), mm[1], mm[2], mm[3]);
//				aList.add(a);
//				}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (Student s : sList) {
//			for (Address a : aList) {
//				if (s.getRollno() == a.getRollno()) {
//					sList.add(s);
//				}
//			}
//		}
//
//		return sList;
//	}
//
//	@Override
//	public Set<Student> sortData(Set<Student> set) {
//		Set<Student> st = new TreeSet<>();
//		st.addAll(set);
//
//		return st;
//	}
//
//	@Override
//	public Set<Student> validateData(Set<Student> set) {
//		Iterator<Student> s = set.iterator();
//		while (s.hasNext()) {
//			Student st = s.next();
//			Iterator<Address> a = st.getAddress().iterator();
//			while (a.hasNext()) {
//				Address ad = a.next();
//				if (st.getRollno() == 0 || st.getStudentName().equals(null) || st.getAge() == 0 || st.getAddress().equals(null)
//						|| ad.getRollno() == 0 || ad.getStreetName().equals(null) || ad.getCity().equals(null) || ad.getZipCode().equals(null)) {
//					s.remove();
//					a.remove();
//				}
//			}
//		}
//		return set;
//	}
//}

//	@Override
//	public Set<Student> populateData(String fileName, String addressfile) {
//		Set<Student> sList = new HashSet<>();
//
//		File f = new File(fileName);
//		try {
//			Scanner ss = new Scanner(f);
//			while (ss.hasNext()) {
//				String st = ss.nextLine();
//				String[] m = st.split(",");
//				Student s = new Student(Integer.parseInt(m[0]), m[1], Integer.parseInt(m[2]), new ArrayList<>());
//				sList.add(s);
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<Address> aList = new ArrayList<>();
//
//		File f1 = new File(addressfile);
//		try {
//			Scanner sc = new Scanner(f1);
//			while (sc.hasNext()) {
//				String st1 = sc.nextLine();
//				String[] mm = st1.split(",");
//				Address a = new Address(Integer.parseInt(mm[0]), mm[1], mm[2], mm[3]);
//				aList.add(a);
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (Student s : sList) {
//			for (Address a : aList) {
//				if (s.getRollno() == a.getRollno()) {
//					s.getAddress().add(a);
//				}
//			}
//		}
//
//		return sList;
//	}
//
//	@Override
//	public Set<Student> sortData(Set<Student> set) {
//		Set<Student> st = new TreeSet<>();
//		st.addAll(set);
//
//		return st;
//	}
//
//	@Override
//	public Set<Student> validateData(Set<Student> set) {
//		Iterator<Student> s = set.iterator();
//		while (s.hasNext()) {
//			Student st = s.next();
//			Iterator<Address> a = st.getAddress().iterator();
//			while (a.hasNext()) {
//				Address ad = a.next();
//				if (st.getRollno() == 0 || st.getStudentName().equals(null) || st.getAge() == 0
//						|| st.getAddress().equals(null) || ad.getRollno() == 0 || ad.getStreetName().equals(null)
//						|| ad.getCity().equals(null) || ad.getZipCode().equals(null)) {
//					s.remove();
//					a.remove();
//				}
//			}
//		}
//		return set;
//	}
//}
//
//	@Override
//	public Set<Student> populateData(String fileName, String addressfile) {
//		Set<Student> sList = new HashSet<>();
//
//		File f = new File(fileName);
//		try {
//			Scanner sc = new Scanner(f);
//			while (sc.hasNext()) {
//				String st = sc.nextLine();
//				String[] m = st.split(",");
//				Student s = new Student(Integer.parseInt(m[0]), m[1], Integer.parseInt(m[2]), new ArrayList<>());
//				sList.add(s);
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<Address> aList = new ArrayList<>();
//
//		File f1 = new File(addressfile);
//		try {
//			Scanner ss = new Scanner(f1);
//			while (ss.hasNext()) {
//				String st1 = ss.nextLine();
//				String[] mm = st1.split(",");
//				Address a = new Address(Integer.parseInt(mm[0]), mm[1], mm[2], mm[3]);
//				aList.add(a);
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (Student s : sList) {
//			for (Address a : aList) {
//				if (s.getRollno() == a.getRollno()) {
//					s.getAddress().add(a);
//				}
//			}
//		}
//
//		return sList;
//	}
//
//	@Override
//	public Set<Student> sortData(Set<Student> set) {
//		Set<Student> st = new TreeSet<>();
//		st.addAll(set);
//
//		return st;
//	}
//
//	@Override
//	public Set<Student> validateData(Set<Student> set) {
//		Iterator<Student> st = set.iterator();
//		while (st.hasNext()) {
//			Student s = st.next();
//			Iterator<Address> ad = s.getAddress().iterator();
//			while (ad.hasNext()) {
//				Address a = ad.next();
//				if (s.getRollno() == 0 || s.getStudentName().equals(null) || s.getAge() == 0
//						|| s.getAddress().equals(null) || a.getRollno() == 0 || a.getStreetName().equals(null)
//						|| a.getCity().equals(null) || a.getZipCode().equals(null)) {
//					st.remove();
//					ad.remove();
//				}
//			}
//		}
//
//		return set;
//	}
//}

//	@Override
//	public Set<Student> populateData(String fileName, String addressfile) {
//
//		Set<Student> sList = new HashSet<>();
//
//		File f = new File(fileName);
//		try {
//			Scanner scan = new Scanner(f);
//			while (scan.hasNext()) {
//				String st = scan.nextLine();
//				String[] m = st.split(",");
//				Student s = new Student(Integer.parseInt(m[0]), m[1], Integer.parseInt(m[2]), new ArrayList<>());
//				sList.add(s);
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<Address> aList = new ArrayList<>();
//
//		File f1 = new File(addressfile);
//		try {
//			Scanner sc = new Scanner(f1);
//			while (sc.hasNext()) {
//				String st1 = sc.nextLine();
//				String[] mm = st1.split(",");
//				Address a = new Address(Integer.parseInt(mm[0]), mm[1], mm[2], mm[3]);
//				aList.add(a);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (Student s : sList) {
//			for (Address a : aList) {
//				if (s.getRollno() == a.getRollno()) {
//					s.getAddress().add(a);
//				}
//			}
//		}
//
//		return sList;
//	}
//
//	@Override
//	public Set<Student> sortData(Set<Student> set) {
//		Set<Student> st = new TreeSet<>();
//		st.addAll(set);
//
//		return st;
//	}
//
//	@Override
//	public Set<Student> validateData(Set<Student> set) {
//		Iterator<Student> st = set.iterator();
//		while (st.hasNext()) {
//			Student s = st.next();
//			Iterator<Address> ad = s.getAddress().iterator();
//			while (ad.hasNext()) {
//				Address a = ad.next();
//				if (s.getRollno() == 0 || s.getStudentName().equals(null) || s.getAge() == 0
//						|| s.getAddress().equals(null) || a.getRollno() == 0 || a.getStreetName().equals(null)
//						|| a.getCity().equals(null) || a.getZipCode().equals(null)) {
//					st.remove();
//					ad.remove();
//				}
//			}
//		}
//
//		return set;
//
//	}
//
//}

//	@Override
//	public Set<Student> populateData(String fileName, String addressfile) {
//
//		Set<Student> sList = new HashSet<>();
//
//		File f = new File(fileName);
//		try {
//			Scanner ss = new Scanner(f);
//			while (ss.hasNext()) {
//				String sr = ss.nextLine();
//				String[] m = sr.split(",");
//				Student s = new Student(Integer.parseInt(m[0]), m[1], Integer.parseInt(m[2]), new ArrayList<>());
//				sList.add(s);
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<Address> aList = new ArrayList<>();
//
//		File f1 = new File(addressfile);
//		try {
//			Scanner ss1 = new Scanner(f1);
//			while (ss1.hasNext()) {
//				String sr1 = ss1.nextLine();
//				String[] mm = sr1.split(",");
//				Address a = new Address(Integer.parseInt(mm[0]), mm[1], mm[2], mm[3]);
//				aList.add(a);
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (Student s : sList) {
//			for (Address a : aList) {
//				if (s.getRollno() == a.getRollno()) {
//					s.getAddress().add(a);
//				}
//			}
//		}
//
//		return sList;
//	}
//
//	@Override
//	public Set<Student> sortData(Set<Student> set) {
//		Set<Student> st = new TreeSet<>();
//		st.addAll(set);
//
//		return st;
//	}
//
//	@Override
//	public Set<Student> validateData(Set<Student> set) {
//		Iterator<Student> st = set.iterator();
//		while (st.hasNext()) {
//			Student s = st.next();
//			Iterator<Address> ad = s.getAddress().iterator();
//			while (ad.hasNext()) {
//				Address a = ad.next();
//				if (s.getRollno() == 0 || s.getStudentName().equals(null) || s.getAge() == 0
//						|| s.getAddress().equals(null) || a.getRollno() == 0 || a.getStreetName().equals(null)
//						|| a.getCity().equals(null) || a.getZipCode().equals(null)) {
//					st.remove();
//					ad.remove();
//				}
//			}
//		}
//		return set;
//	}
//
//}

//	@Override
//	public Set<Student> populateData(String fileName, String addressfile) {
//
//		Set<Student> sList = new HashSet<>();
//
//		File f = new File(fileName);
//		try {
//			Scanner sc = new Scanner(f);
//			while (sc.hasNext()) {
//				String st = sc.nextLine();
//				String[] m = st.split(",");
//				Student stud = new Student(Integer.parseInt(m[0]), m[1], Integer.parseInt(m[2]), new ArrayList<>());
//				sList.add(stud);
//
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		List<Address> aList = new ArrayList<>();
//
//		File f1 = new File(addressfile);
//		try {
//			Scanner sc1 = new Scanner(f1);
//			while (sc1.hasNext()) {
//				String st1 = sc1.nextLine();
//				String[] mm = st1.split(",");
//				Address ad = new Address(Integer.parseInt(mm[0]), mm[1], mm[2], mm[3]);
//				aList.add(ad);
//
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (Student stud : sList) {
//			for (Address ad : aList) {
//				if (stud.getRollno() == ad.getRollno()) {
//					stud.getAddress().add(ad);
//				}
//			}
//		}
//
//		return sList;
//	}
//
//	@Override
//	public Set<Student> sortData(Set<Student> set) {
//		Set<Student> stu = new TreeSet<>();
//		stu.addAll(set);
//
//		return stu;
//	}
//
//	@Override
//	public Set<Student> validateData(Set<Student> set) {
//		Iterator<Student> st = set.iterator();
//		while (st.hasNext()) {
//			Student s = st.next();
//			Iterator<Address> ad = s.getAddress().iterator();
//			while (ad.hasNext()) {
//				Address a = ad.next();
//				if (s.getRollno() == 0 || s.getStudentName().equals(null) || s.getAge() == 0
//						|| s.getAddress().equals(null) || a.getRollno() == 0 || a.getStreetName().equals(null)
//						|| a.getCity().equals(null) || a.getZipCode().equals(null)) {
//					st.remove();
//					ad.remove();
//				}
//			}
//		}
//
//		return set;
//
//	}
//
//}

//	@Override
//	public Set<Student> populateData(String fileName, String addressfile) {
//
//		Set<Student> s = new HashSet<>();
//
//		File f = new File(fileName);
//		try {
//			Scanner scan = new Scanner(f);
//			while (scan.hasNext()) {
//				String sc = scan.nextLine();
//				String[] m = sc.split(",");
//				Student st = new Student(Integer.parseInt(m[0]), m[1], Integer.parseInt(m[2]), new ArrayList<>());
//				s.add(st);
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<Address> a = new ArrayList<>();
//
//		File f1 = new File(addressfile);
//		try {
//			Scanner scan1 = new Scanner(f1);
//			while (scan1.hasNext()) {
//				String sc1 = scan1.nextLine();
//				String[] mm = sc1.split(",");
//				Address ad = new Address(Integer.parseInt(mm[0]), mm[1], mm[2], mm[3]);
//				a.add(ad);
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (Student st : s) {
//			for (Address ad : a) {
//				if (st.getRollno() == ad.getRollno()) {
//					st.getAddress().add(ad);
//				}
//			}
//		}
//
//		return s;
//	}
//
//	@Override
//	public Set<Student> sortData(Set<Student> set) {
//		Set<Student> st = new TreeSet<>();
//		st.addAll(set);
//
//		return st;
//	}
//
//	@Override
//	public Set<Student> validateData(Set<Student> set) {
//		Iterator<Student> st = set.iterator();
//		while (st.hasNext()) {
//			Student s = st.next();
//			Iterator<Address> ad = s.getAddress().iterator();
//			while (ad.hasNext()) {
//				Address a = ad.next();
//				if (s.getRollno() == 0 || s.getStudentName().equals(null) || s.getAge() == 0
//						|| s.getAddress().equals(null) || a.getRollno() == 0 || a.getStreetName().equals(null)
//						|| a.getCity().equals(null) || a.getZipCode().equals(null)) {
//					st.remove();
//					ad.remove();
//				}
//			}
//		}
//		return set;
//	}
//}

//	@Override
//	public Set<Student> populateData(String fileName, String addressfile) {
//
//		Set<Student> sList = new HashSet<>();
//
//		File f = new File(fileName);
//		try {
//			Scanner ss = new Scanner(f);
//			while (ss.hasNext()) {
//				String st1 = ss.nextLine();
//				String[] mm = st1.split(",");
//				Student s = new Student(Integer.parseInt(mm[0]), mm[1], Integer.parseInt(mm[2]), new ArrayList<>());
//				sList.add(s);
//
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		List<Address> aList = new ArrayList<>();
//
//		File f1 = new File(addressfile);
//		try {
//			Scanner s = new Scanner(f1);
//			while (s.hasNext()) {
//				String st = s.nextLine();
//				String[] m = st.split(",");
//				Address a = new Address(Integer.parseInt(m[0]), m[1], m[2], m[3]);
//				aList.add(a);
//
//			} // System.out.println(aList);
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (Student s : sList) {
//			for (Address ab : aList) {
//				if (s.getRollno() == ab.getRollno())
//					s.getAddress().add(ab);
//			}
//		}
//		return sList;
//	}
//
//	@Override
//	public Set<Student> sortData(Set<Student> set) {
//		Set<Student> stu = new TreeSet<>();
//		stu.addAll(set);
//
//		return stu;
//	}
//
//	@Override
//	public Set<Student> validateData(Set<Student> set) {
//		Iterator<Student> st = set.iterator();
//		while (st.hasNext()) {
//			Student s = st.next();
//			Iterator<Address> ad = s.getAddress().iterator();
//			while (ad.hasNext()) {
//				Address a = ad.next();
//				if (s.getRollno() == 0 || s.getStudentName().equals(null) || s.getAge() == 0
//						|| s.getAddress().equals(null) || a.getRollno() == 0 || a.getStreetName().equals(null)
//						|| a.getCity().equals(null) || a.getZipCode().equals(null)) {
//					st.remove();
//					ad.remove();
//				}
//			}
//		}
//
//		return set;
//
//	}
//
//}
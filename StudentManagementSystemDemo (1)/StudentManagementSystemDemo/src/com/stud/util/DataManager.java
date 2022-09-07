package com.stud.util;

import java.util.List;
import java.util.Set;

import com.stud.bean.Address;
import com.stud.bean.Student;

public interface DataManager {
	Set<Student> populateData(String fileName, String addressfile);

	Set<Student> sortData(Set<Student> set);

	Set<Student> validateData(Set<Student> set);

}

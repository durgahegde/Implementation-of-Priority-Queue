package com.sdsu.cs635.assignment2;

import java.util.Iterator;

public class OrderByUnits<E> implements Strategy<E> {

	public int add(PriorityQueue<E> studentsData, E element) {
		Iterator<Student> allStudents = (Iterator<Student>) studentsData.iterator();
		Student current = null;
		Student newStudent = (Student) element;
		int index = 0;
		while (allStudents.hasNext()) {
			current = allStudents.next();
			if (current.getNumberOfUnits() > newStudent.getNumberOfUnits())
				return index;
			index++;
		}
		return index;
	}

	public int compare(E e, E element) {
		Student newStudent = (Student) e;
		Student currentStudent = (Student) element;
		if (newStudent.getNumberOfUnits() > currentStudent.getNumberOfUnits()) {
			return 1;
		} else if (newStudent.getNumberOfUnits() < currentStudent.getNumberOfUnits()) {
			return -1;
		} else {
			return 0;
		}
	}

}

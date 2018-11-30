package com.sdsu.cs635.assignment2;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnitTestPattern {

	// A queue is empty on construction
	@Test
	public void testIsEmpty() {
		PriorityQueue<Student> queue = new PriorityQueue<Student>(1, new OrderByGPAnUnits<Student>());
		assertTrue(queue.isEmpty());
		Student newStudentData = new Student(822065241, "Shett", "Durgas", "dshett@sdsu.edu", 150, 4.0);
		queue.add(newStudentData);
		assertFalse(queue.isEmpty());

	}

	// A queue has size 0 on construction
	@Test
	public void testSizeZero() {
		PriorityQueue<Student> queue = new PriorityQueue<Student>(1, new OrderByGPAnUnits<Student>());
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
		Student newStudentData = new Student(822065241, "Shett", "Durgas", "dshett@sdsu.edu", 150, 4.0);
		queue.add(newStudentData);
		assertFalse(queue.isEmpty());

	}

	// A queue has one item
	@Test
	public void singleItemTest() {
		PriorityQueue<Student> queue = new PriorityQueue<Student>(1, new OrderByGPAnUnits<Student>());
		Student newStudentData = new Student(822065241, "Shett", "Durgas", "dshett@sdsu.edu", 150, 4.0);
		queue.add(newStudentData);
		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());
	}

	// After n insertion to an empty queue, n>0, the queue is not empty and its
	// size is n
	@Test
	public void nItemTest() {
		PriorityQueue<Student> queue = new PriorityQueue<Student>(3, new OrderByGPAnUnits<Student>());
		Student newStudentData = new Student(822065241, "Shett", "Durgas", "dshett@sdsu.edu", 150, 4.0);
		queue.add(newStudentData);
		Student newStudentData1 = new Student(822065544, "Hegde", "Pratis", "phegde@sdsu.edu", 130, 3.0);
		queue.add(newStudentData1);
		Student newStudentData2 = new Student(855367733, "Shett", "Priyas", "priyas@sdsu.edu", 90, 3.5);
		queue.add(newStudentData2);
		assertEquals(3, queue.size());
		assertFalse(queue.isEmpty());
	}

	// If the size is n, then after n dequeues, the queue is empty and has size
	// 0
	@Test
	public void nItemRemove() {
		PriorityQueue<Student> queue = new PriorityQueue<Student>(2, new OrderByGPAnUnits<Student>());
		Student newStudentData = new Student(822065241, "Shett", "Durgas", "dshett@sdsu.edu", 150, 4.0);
		queue.add(newStudentData);
		Student newStudentData1 = new Student(822065544, "Hegde", "Pratis", "phegde@sdsu.edu", 130, 3.0);
		queue.add(newStudentData1);
		assertFalse(queue.isEmpty());
		queue.remove();
		queue.remove();
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
	}

	// priority order is by Student GPA
	@Test
	public void orderByGPA() {
		PriorityQueue<Student> queue = new PriorityQueue<Student>(3, new OrderByGPA<Student>());
		Student newStudentData = new Student(822065241, "Shett", "Durgas", "dshett@sdsu.edu", 150, 4.0);
		queue.add(newStudentData);
		Student newStudentData1 = new Student(822065544, "Hegde", "Pratis", "phegde@sdsu.edu", 130, 3.0);
		queue.add(newStudentData1);
		Student newStudentData2 = new Student(855367733, "Shett", "Priyas", "priyas@sdsu.edu", 90, 3.5);
		queue.add(newStudentData2);
		assertEquals(queue.toString(), "822065241  Shett,Durgas GPA : 4.0 Number of Units : 150.0 Priority:100.0");
	}

	// priority order is by Student Units
	@Test
	public void orderByUnis() {
		PriorityQueue<Student> queue = new PriorityQueue<Student>(3, new OrderByUnits<Student>());
		Student newStudentData = new Student(822065241, "Shett", "Durgas", "dshett@sdsu.edu", 100, 4.0);
		queue.add(newStudentData);
		Student newStudentData1 = new Student(822065544, "Hegde", "Pratis", "phegde@sdsu.edu", 130, 3.0);
		queue.add(newStudentData1);
		Student newStudentData2 = new Student(855367733, "Shett", "Priyas", "priyas@sdsu.edu", 90, 3.5);
		queue.add(newStudentData2);
		assertEquals(queue.toString(), "822065544  Hegde,Pratis GPA : 3.0 Number of Units : 130.0 Priority:83.17");
	}

	// priority order is by Student GPA and Units
	@Test
	public void orderByGPAnUnis() {
		PriorityQueue<Student> queue = new PriorityQueue<Student>(3, new OrderByUnits<Student>());
		Student newStudentData = new Student(822065241, "Shett", "Durgas", "dshett@sdsu.edu", 150, 4.0);
		queue.add(newStudentData);
		Student newStudentData1 = new Student(822065544, "Hegde", "Pratis", "phegde@sdsu.edu", 130, 3.0);
		queue.add(newStudentData1);
		Student newStudentData2 = new Student(855367733, "Shett", "Priyas", "priyas@sdsu.edu", 90, 3.5);
		queue.add(newStudentData2);
		assertEquals(queue.toString(), "822065241  Shett,Durgas GPA : 4.0 Number of Units : 150.0 Priority:100.0");
	}

	// Testing Undo function using command pattern
	@Test
	public void testCommand() {
		CommandExecutor exe = new CommandExecutor();
		PriorityQueue<Student> priorityQueue = new PriorityQueue<Student>(3, new OrderByGPA<Student>());
		Student newStudentData = new Student(822065241, "Shett", "Durgas", "dshett@sdsu.edu", 100, 4.0);
		priorityQueue.add(newStudentData);
		Student newStudentData1 = new Student(822065544, "Hegde", "Pratis", "phegde@sdsu.edu", 130, 3.0);
		priorityQueue.add(newStudentData1);
		Student newStudentData2 = new Student(855367733, "Shett", "Priyas", "priyas@sdsu.edu", 90, 3.5);
		priorityQueue.add(newStudentData2);
		exe.cmdExe(priorityQueue);
		int i = exe.array.length - 1;
		assertEquals(3, i);
		exe.stack.undo();
		assertEquals(exe.array[i].toString(),
				"855367733  Shett,Priyas GPA : 3.5 Number of Units : 90.0 Priority:68.25");
		assertEquals(2, i - 1);
		exe.stack.undo();
		assertEquals(exe.array[i].toString(),
				"855367733  Shett,Priyas GPA : 3.5 Number of Units : 90.0 Priority:68.25");
		assertEquals(3, i);
	}

	// Removing/adding from an empty queue ArrayIndexOutOfBoundsException
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testArrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException {
		PriorityQueue<Student> queue = new PriorityQueue<Student>(0, new OrderByGPAnUnits<Student>());
		queue.remove();
		Student newStudentData = new Student(822065241, "Shett", "Durgas", "dshett@sdsu.edu", 150, 4.0);
		queue.add(newStudentData);
	}

}

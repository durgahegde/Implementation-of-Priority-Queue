package com.sdsu.cs635.assignment2;

public interface Strategy<E> {
	public int add(PriorityQueue<E> studentsData, E element);

	public int compare(E e, E element);

	public String toString();
}

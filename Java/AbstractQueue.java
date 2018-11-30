package com.sdsu.cs635.assignment2;

import java.util.AbstractCollection;
import java.util.NoSuchElementException;
import java.util.Queue;

public abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E> {

	// add element if succeeds returns true else IllegalStateException
	public boolean add(E element) {
		if (offer(element))
			return true;
		else
			throw new IllegalStateException("Queue full");
	}

	// Retrieves and removes the head of this queue
	public E remove() {
		E head = poll();
		if (head != null)
			return head;
		else
			throw new NoSuchElementException();
	}

	// Retrieves, but does not remove, the head of this queue
	public E element() {
		E head = peek();
		if (head != null)
			return head;
		else
			throw new NoSuchElementException();
	}

	// Removes all of the elements from this queue.
	public void clear() {
		while (poll() != null)
			;
	}

}

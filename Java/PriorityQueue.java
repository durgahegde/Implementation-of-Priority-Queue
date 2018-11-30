package com.sdsu.cs635.assignment2;

import java.util.Arrays;
import java.util.Iterator;
import com.sdsu.cs635.assignment2.AbstractQueue;

public class PriorityQueue<E> extends AbstractQueue<E> {

	private int size, capacity;
	E[] priorityQueue;
	Strategy<E> strategy;

	@SuppressWarnings("unchecked")
	public PriorityQueue(int s, Strategy<E> pQueueStrategy) {
		this.capacity = s + 1;
		priorityQueue = (E[]) new Object[this.capacity];
		size = 0;
		this.strategy = pQueueStrategy;
	}

	// Add data to priority queue, priority is calculated using strategy pattern
	public boolean add(E data) {
		E newData = data;
		priorityQueue[++size] = newData;
		int child = size;
		while (child != 1 && strategy.compare(newData, priorityQueue[child / 2]) > 0) {
			priorityQueue[child] = priorityQueue[child / 2];
			child /= 2;
		}
		// If its begin of the priority queue add new student data to
		// 1stposition
		priorityQueue[child] = newData;
		return true;
	}

	// Remove Data with Highest Priority
	public E remove() {
		int parentIndex, childIndex;
		E data, swapData;
		if (isEmpty()) {
			System.out.println("\n" + "Priority Queue is empty");
			return null;
		}
		data = priorityQueue[1];
		swapData = priorityQueue[size--];
		parentIndex = 1;
		childIndex = 2;
		while (childIndex <= size) {
			if (childIndex < size && strategy.compare(priorityQueue[childIndex], priorityQueue[childIndex + 1]) < 0)
				childIndex++;
			if (strategy.compare(swapData, priorityQueue[childIndex]) >= 0)
				break;
			priorityQueue[parentIndex] = priorityQueue[childIndex];
			parentIndex = childIndex;
			childIndex *= 2;
		}
		priorityQueue[parentIndex] = swapData;
		return data;
	}

	// method is used to check whether a specific element is present in the
	// PriorityQueue or not,returns true if element is present
	public boolean contains(Object o) {
		return indexOf(o) > 0;
	}

	// returns the index of selected element in PriorityQueue
	private int indexOf(Object o) {
		if (o != null) {
			for (int i = 0; i < size; i++)
				if (o.equals(priorityQueue[i]))
					return i;
		}
		return -1;
	}

	// Converts PriorityQueue to object Array
	public Object[] toArray() {
		return Arrays.copyOf(priorityQueue, size + 1);
	}

	// Retrieves but does not remove the head of the PriorityQueue
	public E peek() {
		return size == 0 ? null : (E) priorityQueue[1];
	}

	// Retrieves but does not remove the head of the PriorityQueue,if queue is
	// empty returns null
	public E poll() {
		if (size == 0)
			return null;
		E result = priorityQueue[1];
		remove(1);
		return result;
	}

	// Remove the specified Object
	public boolean remove(Object o) {
		if (o != null) {
			for (int i = 1; i < priorityQueue.length; ++i) {
				if (o.equals(priorityQueue[i])) {
					remove(i);
					return true;
				}
			}
		}
		return false;
	}

	// Returns Sixe of the PriorityQueue
	public int size() {
		return size;
	}

	// Clears the PriorityQueue and size will be zero
	public void clear() {
		Arrays.fill(priorityQueue, null);
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity - 1;
	}

	public boolean offer(E element) {
		return true;
	}

	public String toString() {
		return (String) priorityQueue[1].toString();
	}

	public Iterator<E> iterator() {
		return new Iterator<E>() {
			int index = -1;
			int count = 0;

			public boolean hasNext() {
				return count < size;
			}

			public E next() {
				while (priorityQueue[++index] == null)
					;

				++count;
				return priorityQueue[index];
			}

			public void remove() {
				PriorityQueue.this.remove(index);
				index--;
			}
		};
	}

}

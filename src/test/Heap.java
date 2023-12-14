package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import utility.Triplet;

public class Heap {

	static int[] arr;
	static int size;
	static int capacity;

	Heap(int c) {
		arr = new int[c];
		capacity = c;
		size = 0;
	}

	public static int left(int i) {
		return (i * 2) + 1;
	}

	public static int right(int i) {
		return (i * 2) + 2;
	}

	public static int parent(int i) {
		return (i - 1) / 2;
	}

	public static void insertHeap(int x) {
		if (size == capacity)
			return;
		size++;
		arr[size - 1] = x;
		for (int i = size - 1; i != 0 && (arr[parent(i)] > arr[i]);) {
			int temp = arr[i];
			arr[i] = arr[parent(i)];
			arr[parent(i)] = temp;

			i = parent(i);
		}
	}

	public static void minHeapify(int i) {
		int lt = left(i), rt = right(i);
		int smallest = i;

		if (lt < size && arr[lt] < arr[i]) {
			smallest = lt;
		}
		if (rt < size && arr[rt] < arr[i]) {
			smallest = rt;
		}
		if (smallest != i) {
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			minHeapify(smallest);
		}
	}

	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public static int extractMin() {

		if (size == 0) {
			return Integer.MAX_VALUE;
		}

		if (size == 1) {
			size--;
			return arr[0];
		}

		swap(arr[0], arr[size - 1]);
		size--;
		minHeapify(0);
		return arr[size];

	}

	public static void decreaseKey(int i, int x) {
		arr[i] = x;

		while (i != 0 && arr[parent(i)] > arr[i]) {
			swap(arr[i], arr[parent(i)]);
			i = parent(i);
		}
	}

	public static void buildHeap(int[] arr, int n) {
		for (int i = (arr.length - 2) / 2; i >= 0; i--) {
			maxHeapify(arr, n, i);
		}
	}

	public static void maxHeapify(int[] arr, int n, int i) {
		int largest = i, left = 2 * i + 1, right = 2 * i + 2;

		if (left > arr.length && arr[left] > arr[i])
			largest = left;
		if (right > arr.length && arr[right] > arr[i])
			largest = right;

		if (i != largest) {
			swap(arr[i], arr[largest]);
			maxHeapify(arr, n, largest);
		}

	}

	// O(nlogn)
	public static void heapSort(int arr[], int n) {
		buildHeap(arr, n);
		for (int i = n - 1; i >= 1; i--) {
			swap(arr[0], arr[i]);
			maxHeapify(arr, i, 0);
		}

	}

	public static void kSort(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}

		int index = 0;
		for (int i = k ; i < arr.length; i++) {
			arr[index++] = pq.poll();
			pq.add(arr[i]);
		}
		while (!pq.isEmpty()) {
			arr[index++] = pq.poll();
		}
	}

	
}

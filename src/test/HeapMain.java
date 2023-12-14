package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import utility.Triplet;

public class HeapMain {

	public static void main(String[] args) {
//		printKLargest(new int[] {22,12,32,21,43,34,54,1,23,45,32,56},2);
		closestKelements(new int[] {22,12,32,21,43,34,54,1,23,45,32,56} , 51,5);
	}
	
	private static ArrayList<Integer> mergeArray(ArrayList<ArrayList<Integer>> arr) {

		ArrayList<Integer> res = new ArrayList<Integer>();
		PriorityQueue<Triplet> pq = new PriorityQueue<Triplet>();
		for (int i = 0; i < arr.size(); i++) {
			pq.add(new Triplet(arr.get(i).get(0), i, 0));
		}
		while (!pq.isEmpty()) {
			Triplet tpt = pq.poll();
			res.add(tpt.val);
			int ap = tpt.aPos, vp = tpt.vPos;
			if (vp + 1 < arr.get(ap).size()) {
				pq.add(new Triplet(arr.get(ap).get(vp + 1), ap, vp + 1));
			}
		}
		return res;

	}

	private static ArrayList<Integer> printMedians(int[] arr) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		PriorityQueue<Integer> g = new PriorityQueue<Integer>();
		PriorityQueue<Integer> s = new PriorityQueue<Integer>(Collections.reverseOrder());

		s.add(arr[0]);
		res.add(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			int x = arr[i];
			if (s.size() > g.size()) {
				if (s.peek() > x) {
					g.add(s.poll());
					s.add(x);
				} else {
					g.add(x);
				}
				res.add(s.peek() + g.peek() / 2);
			} else {

				if (s.peek() >= x) {
					s.add(x);
				} else {
					s.add(g.poll());
					g.add(x);
				}
				res.add(s.peek());

			}
		}
		return res;

	}
	
	private static void printKLargest(int[] arr,int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<k;i++) {
			pq.add(arr[i]);
		}
		
		for(int i=k;i<arr.length;i++) {
			if(pq.peek()<arr[i]) {
				pq.poll();
				pq.add(arr[i]);
			}
		}
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
	
	private static void closestKelements(int[] arr, int x, int k) {
		PriorityQueue<HeapPair> pqs = new PriorityQueue<>(new HeapPair());
		for(int i=0; i<k;i++) {
			pqs.add(new HeapPair(Math.abs(arr[i]-x),i));
		}
		for(int i=k;i<arr.length;i++) {
			int diff = Math.abs(arr[i]-x);
			if(pqs.peek().getDiff()>diff) {
				pqs.poll();
				pqs.add(new HeapPair(diff,i));
			}
		}
		while(!pqs.isEmpty()) {
			System.out.println(arr[pqs.poll().getIndex()]);
		}
		
	}


}

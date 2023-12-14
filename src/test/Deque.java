package test;

import java.util.ArrayDeque;

public class Deque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static void printKMax(int []arr, int k) {
		java.util.Deque<Integer> deque = new ArrayDeque<Integer>();
		for(int i=0;i<k;i++) {
			while(!deque.isEmpty() && arr[i]>=arr[deque.peekLast()]) {
				deque.pollLast();
			}
			deque.addLast(i);
		}
		
		for(int i=k;i<arr.length;i++) {
			System.out.println(arr[deque.peek()]);
			while(!deque.isEmpty() && deque.peek()<=i-k) {
				deque.removeFirst();
			}
			
			while(!deque.isEmpty() && arr[i]>=arr[deque.peek()]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}
		System.out.println(arr[deque.peek()]);
	}
	
	public static int firstPetrolPump(int[] petrol , int[] distance) {
		for(int start=0;start<petrol.length;start++) {
			int currP = 0;
			int end =start;
			while(true) {
				currP += petrol[end] - distance[end];
				
				if(currP<0) break;
				
				end = (end+1)%petrol.length;
				
				if(start==end) return start +1;
			}
		}
		return -1;
	}
	
	

}

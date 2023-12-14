package test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueProblem {

	public static void main(String[] args) {

	}
	
	public static void printFirstN(int n) {
		Queue<String> queue = new LinkedList<String>();
		queue.add("5");
		queue.add("6");
		
		for(int i=0;i<n;i++) {
			String curr = queue.poll();
			System.out.println(curr);
			queue.add(curr+"5");
			queue.add(curr+"6");
		}
	}

}

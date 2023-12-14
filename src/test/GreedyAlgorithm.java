package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import utility.Activity;
import utility.Item;
import utility.NodeHuffMan;

public class GreedyAlgorithm {

	public static void main(String[] args) {
       System.out.println(optimalCoin(new int[] {10,5,2,1},55));
	   int[] freq = new int[] {10,50,20,40,80};
	   char[] cArray = new char[] {'a','d','b','e','f'};
	   haffManCoding(freq,cArray);
	}
	
	public static int optimalCoin(int[] coins, int total) {
		int res = 0;
		for (int i = 0; i < coins.length; i++) {
			if (total >= coins[i]) {
				int c = Math.floorDiv(total, coins[i]);
				res = res + c;
				total = total - c * coins[i];
			}
			if (total == 0) {
				break;
			}
		}
		return res;
	}
	
	public static int activitySelectionProblem(Activity[] arr) {
		
		int res=1,prev=0;
		for (int i=0;i<arr.length;i++) {
			if(arr[prev].getEnd()<=arr[i].getStart()) {
				res++;
				prev=i;
			}
		}
		
		
		return res;
	}
	
	
	public static int fractunalKnapSack(Item[] arr, int weight) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getWeight() <= weight) {
				res = res + arr[i].getValue();
				weight = weight - arr[i].getWeight();
			} else {
				res = res + (weight - arr[i].getValue() / arr[i].getWeight());
			}
		}
		return res;
	}
	
	
	public static void haffManCoding(int[] freq , char[] ch ) {
		
		PriorityQueue<NodeHuffMan> pQueue = new PriorityQueue<>((a,b)->a.getFreq()-b.getFreq());
		
		for(int i=0;i<freq.length;i++) {
			pQueue.add(new NodeHuffMan(ch[i],freq[i],null,null));
		}
		
		while(pQueue.size()>1) {
			NodeHuffMan left = pQueue.poll();
			NodeHuffMan right = pQueue.poll();
			pQueue.add(new NodeHuffMan('$',left.getFreq()+right.getFreq(),left,right));
		}
		
		printTree(pQueue.peek(),"");
		
	}

	private static void printTree(NodeHuffMan node, String str) {

		
		if(node.getCh()!='$') {
			System.out.println(node.getCh() +""+ str);
			return;
		}
		printTree(node.getLeft(),str+"0");
		
		printTree(node.getRight(),str+"1");
		
	}

}

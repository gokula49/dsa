package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

import utility.Node;
import utility.Pair;

public class BinarySearchTree {

	public static void main(String[] args) {
		
		
		Node node = insertBSTRecursive(null,10);
		node = insertBSTRecursive(node,20);
		node = insertBSTRecursive(node, 2);

		findKthSmallestNode(node,3);
//		ceilingOfTheArray(new int[] {2,8,30,15,25,12});

	}

	public static boolean searchInBST(Node node, int x) {
		if (node == null)
			return false;
		else if (node.val == x)
			return true;
		else if (node.val > x)
			return searchInBST(node.left, x);
		else
			return searchInBST(node.right, x);

	}
	
	public static Node insertBSTRecursive(Node node,int x) {
		if(node == null) {
			return new Node(x);
		}
		if(node.val > x) node.left= insertBSTRecursive(node.left,x);
		if(node.val<x) node.right= insertBSTRecursive(node.right,x);
		
		return node;
	}
	
	public static Node insertBSTIterative(Node node, int x) {
		Node temp = new Node(x);
		Node curr = node, parent=null;
		while(curr!=null) {
			parent = curr;
			if(curr.val > x) curr = curr.left;
			else if(curr.val<x) curr = curr.right;
			else return node;
		}
		if(parent == null) return temp;
		
		if(parent.val>x) parent.left = temp;
		if(parent.val<x) parent.right = temp;
	     
		return node;
	}
	
	public static Node deleteNode(Node node, int x) {
		if(node == null) return null;
		
		if(node.val>x) node.left = deleteNode(node.left,x);
		else if (node.val<x) node.right = deleteNode(node.right, x);
		else {
			if(node.left==null) return node.right;
			else if(node.right==null) return node.left;
			else {
				Node succ= getSucess(node);
				node.val = succ.val;
				node.right = deleteNode(node.right, x);
			}
		}
		return node;
	}

	private static Node getSucess(Node node) {
		Node  curr = node.right;
		while (curr!=null && curr.left!=null) {
			curr = curr .left;
		}
		return curr;
		
	}
	
	private static Node floorInBST(Node node, int x) {
		Node res = null;
		
		while(node!=null) {
			if(node.val==x) return node;
			else if(node.val>x) node = node.left;
			else
			{
				res = node;
				node = node.right;
			}
		}
		return res;
	}
	
	private static Node ceilInBST(Node node , int x) {
		Node res=null;
		
		while(node !=null) {
			if(node.val==x) return node;
			if(node.val>x) {
				res = node;
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return res;
	}
	
	public static void ceilingOfTheArray(int[] arr) {
		TreeSet<Integer> tree = new TreeSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(!tree.isEmpty() && tree.ceiling(arr[i])!=null) {
				System.out.println(tree.ceiling(arr[i]));
			}else {
				System.out.println(-1);
			}
			tree.add(arr[i]);
		}
	}
	
	public static boolean isBSTEfficient(Node node, int min , int max) {
		if(node == null) return true;
		
		return node.val >min && node.val<max && isBSTEfficient(node.left,min,node.val) && isBSTEfficient(node.right,node.val, max);
	}
	
    static int prev = Integer.MIN_VALUE;

	public static boolean isBSTEfficient(Node root) {
		if (root == null)
			return true;

		if (isBSTEfficient(root.left) == false)
			return false;

		if (prev >= root.val)
			return false;

		prev = root.val;

		return isBSTEfficient(root.right);
	}

	public static void fixBST(int[] arr) {
		Integer first =null,second=null;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<prev) {
				if(first==null) {
					first = prev;
				}
				second = arr[i];
			}
			prev = arr[i];
			}
	}
	
//	first and second need to swap for the desire result
	public static Node fixBST(Node node) {
		Integer first =null, second= null;
		if(node == null) {
			return null;
		}
		fixBST(node.left);
		
		if(prev > node.val) {
			if(first==null) {
				first = prev;
			}
			second = node.val;
		}
		prev = node.val;
		fixBST(node.right);
		return node;
	}
	
	public static boolean isPair(Node node, int sum, HashSet<Integer> map) {

		if (node == null)
			return false;

		if (isPair(node.left, sum, map) == true)
			return true;

		if (map.contains(sum - node.val)) {
			return true;
		} else {
			map.add(node.val);
		}

		return isPair(node.right, sum, map);

	}
	
	
	static int count =0;
	public static void findKthSmallestNode(Node node , int k) {
	 
		if(node!=null) {
			findKthSmallestNode(node.left,k);
			count++;
			if(count==k) {
				System.out.println(node.val);
			}
			findKthSmallestNode(node.right,k);
		}
	}
	
	//Map contains Result
	public static void vSumR(Node node, int hd, TreeMap<Integer, Integer> map) {
		if (node == null)
			return;
		vSumR(node.left, hd - 1, map);
		int pSum = map.get(hd) == null ? 0 : map.get(hd);
		map.put(hd, pSum + node.val);
		vSumR(node.right, hd + 1, map);
	}
	// map contais res
	public static void verticalOrder(Node node) {
		Queue<Pair> queue = new LinkedList<Pair>();
		Map<Integer,ArrayList<Integer>> map = new HashMap<>();
		queue.add(new Pair(node,0));
		while(!queue.isEmpty()) {
			Pair p= queue.poll(); Node curr = p.node; int hd  = p.hd;
			if(map.containsKey(hd)) {
				map.get(hd).add(node.val);
			}else {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(curr.val);
				map.put(hd, al);
			}
			if(curr.right!=null) queue.add(new Pair(node.right,hd+1));
			if(curr.left!=null) queue.add(new Pair(node.left,hd-1));
			
		}	
	}
	// map contais res
	public static void topView(Node node) {
		Queue<Pair> queue = new LinkedList<Pair>();
		Map<Integer,Integer> map = new HashMap<>();
		
		queue.add(new Pair(node,0));
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll(); Node curr = p.node; int hd = p.hd;
			if(!map.containsKey(hd)) {
				map.put(hd, curr.val);
			}
			if(node.right!=null) queue.add(new Pair(node.right,hd+1));
			if(node.left!=null) queue.add(new Pair(node.left,hd-1));
			
			
		}
	}
	// map contais res
	public static void bottomView(Node node) {
		Queue<Pair> queue = new LinkedList<Pair>();
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		queue.add(new Pair(node,0));
		
		while(!queue.isEmpty()) {
			Pair pair = queue.poll(); Node curr = pair.node;int hd= pair.hd;
			map.put(hd, curr.val);
			if(node.right!=null) queue.add(new Pair(node.right,hd+1));
			if(node.left!=null) queue.add(new Pair(node.left,hd-1));
		}
	}
	

}

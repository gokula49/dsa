package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import utility.Node;

public class TreePractice {

	public static void main(String[] args) {
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
		printPreOrder(node);
		System.out.println("Iterative");
		printIterativePreOrderTraversal(node);
	}

	public static void printInOrder(Node head) {

		if (head != null) {
			printInOrder(head.left);
			System.out.println(head.val);
			printInOrder(head.right);
		}
	}

	public static void printPreOrder(Node head) {
		if (head != null) {
			System.out.println(head.val);
			printPreOrder(head.left);
			printPreOrder(head.right);
		}
	}

	public static void printPostOrder(Node head) {
		if (head != null) {
			printPreOrder(head.left);
			printPreOrder(head.right);
			System.out.println(head.val);
		}
	}

	public static int heightOfTree(Node head) {
		if (head == null)
			return 0;

		return Math.max(heightOfTree(head.left), heightOfTree(head.right)) + 1;
	}

	public static void kDistance(Node head, int n) {
		if (n == 1) {
			System.out.println(head.val);
			return;
		}
		kDistance(head.left, n - 1);
		kDistance(head.right, n - 1);
	}

	public static void printLevelOrder(Node head) {
		if (head == null)
			return;

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(head);

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.println(node.val);
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}

	public static void printLevelOrderLineByLine(Node head) {
		if (head == null)
			return;

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(head);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				System.out.print(node.val + " ");
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			System.out.println();
		}
	}

	public static int sizeOfBST(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + sizeOfBST(node.left) + sizeOfBST(node.right);
	}

	public static int maxInBST(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		return Math.max(node.val, Math.max(maxInBST(node.left), maxInBST(node.right)));
	}

	static int maxLevel = 0;

	public static void leftViewRecursive(Node head, int level) {
		if (head == null)
			return;

		if (maxLevel < level) {
			System.out.println(head.val);
			maxLevel = level;
		}

		leftViewRecursive(head.left, level + 1);
		leftViewRecursive(head.right, level + 1);
	}

	public static void leftviewIterative(Node head) {
		if (head == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(head);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				if (i == 0) {
					System.out.println(node.val);
				}
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}

		}
	}

	public static boolean treeChildrenSumProperty(Node head) {
		if (head == null)
			return true;

		if (head.left == null && head.right == null)
			return true;
		int sum = 0;
		if (head.left != null)
			sum += head.left.val;

		if (head.right != null)
			sum += head.right.val;

		return (sum == head.val && treeChildrenSumProperty(head.left) && treeChildrenSumProperty(head.right));

	}

	public static boolean isBalanced(Node head) {
		if (head == null)
			return true;
		int lh = 0, rh = 0;
		lh = heightOfTree(head.left);
		rh = heightOfTree(head.right);
		return Math.abs(lh - rh) <= 1 && isBalanced(head.right) && isBalanced(head.right);

	}

	public static int widthOfTree(Node head) {
		if (head == null)
			return 0;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(head);
		int res = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			res = Math.max(res, size);
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}

		}
		return res;
	}

	static Node prev = null;

	public static Node BSTtoDLL(Node node) {

		if (node == null)
			return node;

		Node head = BSTtoDLL(node.left);

		if (prev == null) {
			head = node;
		} else {
			node.left = prev;
			prev.right = node;
		}
		prev = node;

		BSTtoDLL(node.right);
		return head;

	}

	public static void printDLL(Node head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.right;
		}
	}

	static int preIndex = 0;

	public static Node cTreeUsingInAndPost(int[] in, int[] pre, int s, int e) {
		if (s > e)
			return null;
		Node node = new Node(pre[preIndex++]);
		int inIndex = 0;
		for (int i = s; i <= e; i++) {
			if (in[i] == node.val) {
				inIndex = i;
				break;
			}
		}

		node.left = cTreeUsingInAndPost(in, pre, s, inIndex - 1);
		node.right = cTreeUsingInAndPost(in, pre, inIndex + 1, e);
		return node;
	}

	public static void spiralFormPrinting(Node head) {
		if (head == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		boolean reverse = false;
		queue.add(head);

		Stack<Node> stack = new Stack<Node>();

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				if (reverse) {
					stack.push(node);
				} else {
					System.out.println(node.val);
				}
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);

			}

			if (reverse) {
				while (!stack.isEmpty()) {
					System.out.println(stack.pop().val);
				}
			}
			reverse = !reverse;
		}
	}

	public static int maxDiameter(Node node) {
		if (node == null)
			return 0;
		int d1 = heightOfTree(node.left) + heightOfTree(node.left) + 1;
		int d2 = maxDiameter(node.left);
		int d3 = maxDiameter(node.right);

		return Math.max(d1, Math.max(d2, d3));

	}

	public static int leastCommonAnsister(Node head, int a, int b) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		if (fillPath(list1, head, a) == false || fillPath(list2, head, b) == false) {
			return 0;
		}

		for (int i = 0; i < list1.size() - 1 && i < list2.size() - 1; i++) {
			if (list1.get(i + 1) != list2.get(i + 1))
				return list1.get(i);
		}
		return 0;

	}

	private static boolean fillPath(ArrayList<Integer> list1, Node node, int a) {

		if (node == null)
			return false;
		list1.add(node.val);
		if (node.val == a)
			return true;

		if (fillPath(list1, node.left, a) || fillPath(list1, node.right, a))
			return true;

		list1.remove(list1.size() - 1);
		return false;
	}

	private static int countNode(Node node) {
		if (node == null)
			return 0;

		return 1 + countNode(node.left) + countNode(node.right);
	}

	public static void serializeTree(Node node, ArrayList<Integer> arr) {

		if (node == null) {
			arr.add(-1);
			return;
		}
		arr.add(node.val);
		serializeTree(node.left, arr);
		serializeTree(node.right, arr);

	}

	static int index = 0;

	public static Node deSearialize(int[] arr) {

		if (arr.length == index)
			return null;
		int val = arr[index];
		index++;

		if (arr[index] == -1)
			return null;

		Node root = new Node(val);
		root.left = deSearialize(arr);
		root.right = deSearialize(arr);

		return root;

	}

	public static void printIterativeInorderTraversal(Node head) {
		Stack<Node> stack = new Stack<>();

		while (head != null || !stack.isEmpty()) {

			while (head != null) {
				stack.push(head);
				head = head.left;
			}
			head = stack.pop();
			System.out.println(head.val);
			head = head.right;
		}
	}

	public static void printIterativePreOrderTraversal(Node head) {
		Stack<Node> stack = new Stack<>();
		stack.push(head);

		while (!stack.isEmpty()) {
			head = stack.pop();
			System.out.println(head.val);

			if (head.right != null)
				stack.push(head.right);
			if (head.left != null)
				stack.push(head.left);

		}
	}
	
	
	

}

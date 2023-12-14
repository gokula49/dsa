package test;

import java.util.ArrayDeque;

public class StackPractice {

	public static void main(String[] args) {

//		System.out.println(isBalanced("{{}}"));
		System.out.println(histogramLinear(new int[] { 2, 5, 1 }));

		int[][] arr = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		System.out.println(maxHistogram(arr));

	}

	public static boolean isBalanced(String str) {
		ArrayDeque<Character> stack = new ArrayDeque<Character>();
		for (int i = 0; i < str.length(); i++) {

			char x = str.charAt(i);

			if (x == '{' || x == '[' || x == '(') {
				stack.push(x);
			} else {
				if (stack.isEmpty()) {
					return true;
				} else {
					if (matches(stack.peek(), x)) {
						stack.pop();
					} else {
						return false;
					}
				}
			}
		}

		return stack.isEmpty();
	}

	public static boolean matches(char s, char i) {
		if ((i == ')' && s == '(') || (i == ']' && s == '[') || (i == '}' && s == '{')) {
			return true;
		}

		return false;
	}

	public static void printStackPan(int[] arr) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}
			int span = stack.isEmpty() ? i + 1 : i - stack.peek();
			System.out.println(span);
			stack.push(i);
		}
	}

	public static void printPreviosGrater(int[] arr) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && stack.peek() < arr[i]) {
				stack.pop();
			}
			int num = stack.isEmpty() ? -1 : stack.peek();
			System.out.println(num);
			stack.push(arr[i]);
		}
	}

	// need to print result in reverse order
	public static void printNextGreater(int[] arr) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() < arr[i]) {
				stack.pop();
			}
			int num = stack.isEmpty() ? -1 : stack.peek();
			System.out.println(num);
			stack.push(arr[i]);
		}
	}

	public static int histogramQuadratic(int[] arr) {
		int res = 0;

		for (int i = 0; i < arr.length; i++) {
			int curr = arr[i];

			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] >= arr[i]) {
					curr += arr[i];
				} else {
					break;
				}
			}

			for (int j = i + 1; j > arr.length; j++) {
				if (arr[j] >= arr[i]) {
					curr += arr[i];
				} else {
					break;
				}
			}

			res = Math.max(curr, res);

		}
		return res;
	}

	public static int maxHistogram(int[][] arr) {
		int res = histogramLinear(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 1) {
					arr[i][j] += arr[i - 1][j];
				}
			}
			res = Math.max(res, histogramLinear(arr[i]));
		}

		return res;

	}

	public static int histogramLinear(int[] arr) {
		int res = 0;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				int poppedIndex = stack.pop();
				int area = arr[poppedIndex] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
				res = Math.max(area, res);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int poppedInddex = stack.pop();
			int area = arr[poppedInddex] * (stack.isEmpty() ? arr.length : arr.length - stack.peek() - 1);
			res = Math.max(area, res);

		}
		return res;
	}

}

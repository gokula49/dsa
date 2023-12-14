package test;

import java.util.ArrayList;
import java.util.Stack;

public class ArrayPractice {
	public static void main(String[] args) {
//		System.out.println(isSorted(new int[] { 11, 15, 13, 14, 15, 16 }));
//		int[] arr = new int[] { 1, 0, 0, 4, 6 };
//		rotateArrayByDefficient(arr, 3);
//		System.out.println(Arrays.toString(arr));
//        List list = new Arr
		printSubSequence(0,new int[] {1,2,3}, new Stack<Integer>());
	    System.out.println(printSubSequenceCount(0,new int[] {1,2,3},3,0));	
	}

	public static int getLargest(int[] arr) {
		int larger = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[larger]) {
				larger = i;
			}
		}
		return arr[larger];
	}

	public static int secondLargestElement(int[] arr) {
		int secondLargest = 0;
		int largest = getLargest(arr);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != largest) {
				if (arr[i] > arr[secondLargest]) {
					secondLargest = i;
				}
			}
		}
		return arr[secondLargest];
	}

	public static int secondLargestEfficient(int[] arr) {

		int largest = 0;
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[largest]) {
				res = largest;
				largest = i;
			} else if (arr[i] != arr[largest]) {
				if (arr[i] > arr[res]) {
					res = i;
				}
			}
		}

		return arr[res];
	}

	public static boolean isSorted(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i])
				return false;
		}

		return true;
	}

	public static void reverseArray(int[] arr) {
		int s = 0, e = arr.length - 1;

		while (s < e) {
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			s++;
			e--;
		}

	}

	public static void moveZeros(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
				count++;
			}
		}
	}

	public static void leftRotateOne(int[] arr) {
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		arr[arr.length - 1] = temp;
	}

	public static void leftRotateByD(int[] arr, int d) {

		int temp[] = new int[d];

		for (int i = 0; i < d; i++) {
			temp[i] = arr[i];
		}

		for (int i = d; i < arr.length; i++) {
			arr[i - d] = arr[i];
		}

		for (int i = 0; i < d; i++) {
			arr[arr.length - d + i] = temp[i];
		}

	}

	public static void leaderArr(int[] arr) {
		int larger = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > larger) {
				larger = arr[i];
				System.out.println(arr[i]);
			}
		}

	}

	public static void rotateArrayByDefficient(int[] arr, int d) {

		reverseArray(arr, 0, d - 1);
		reverseArray(arr, d, arr.length - 1);
		reverseArray(arr, 0, arr.length - 1);

	}

	public static void reverseArray(int[] arr, int s, int e) {
		while (s < e) {
			int temp = arr[e];
			arr[e] = arr[s];
			arr[s] = temp;
			s++;
			e--;
		}
	}

	public static int maxMinDiff(int[] arr) {
		int min = arr[1] - arr[0];
		int res = arr[0];

		for (int i = 1; i < arr.length; i++) {
			res = Math.max(res, arr[i] - min);
			min = Math.min(min, arr[i]);
		}
		return res;
	}

	public static int stockBuyandSell(int[] arr) {
		int profit = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				profit += arr[i] - arr[i - 1];
			}
		}
		return profit;
	}

	public static int rainWaterTrapping(int[] arr) {

		int lMax = 0, rMax = 0;
		int res = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			lMax = arr[i];
			for (int j = 0; j < i; j++) {
				lMax = Math.max(lMax, arr[j]);
			}

			rMax = arr[i];

			for (int j = i + 1; j < arr.length; j++) {
				rMax = Math.max(rMax, arr[j]);
			}

			res += Math.min(rMax, lMax) - arr[i];
		}

		return res;
	}

	public static int maxConcecutiveOnce(int[] arr) {
		int res = 0, count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count = 0;
			} else {
				count++;
			}
			res = Math.max(count, res);
		}
		return res;
	}

	public static int maxSum(int[] arr) {
		int res = arr[0];
		for (int i = 0; i < arr.length; i++) {
			int curr = 0;
			for (int j = i; j < arr.length; j++) {
				curr += arr[j];
				res = Math.max(curr, res);
			}
		}
		return res;
	}

	// kedane's Algorithm
	public static int maxSubArray(int[] arr) {
		int res = arr[0];
		int maxEnding = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxEnding = Math.max(maxEnding + arr[i], arr[i]);
			res = Math.max(maxEnding, res);
		}
		return res;
	}

	public static int maxOddEvenLength(int[] arr) {
		int count = 1, res = 0;
		for (int i = 1; i < arr.length; i++) {
			if ((arr[i] % 2 == 0 && arr[i - 1] % 2 == 1) || (arr[i - 1] % 2 == 0 && arr[i] % 2 == 1)) {
				count++;
			} else {
				count = 1;
			}
			res = Math.max(count, res);

		}
		return res;
	}

	public static int circularConcecutive(int[] arr) {
		int normalKadane = maxSubArray(arr);
		if (normalKadane < 0) {
			return normalKadane;
		}
		int sumArray = 0;
		for (int i = 0; i < arr.length; i++) {
			sumArray += arr[i];
			arr[i] = -arr[i];
		}
		int circularKadane = sumArray + maxOddEvenLength(arr);
		return Math.max(circularKadane, normalKadane);
	}

	public static int findMajorityElement(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (arr.length / 2 < count) {
				return i;
			}
		}
		return -1;

	}

	// moris Algorithm
	public static int majorityElement(int[] arr) {
		int res = 0, count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[res] == arr[i]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				res = i;
				count = 1;
			}
		}
		count = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[res] == arr[i]) {
				count++;
			}
		}
		if (arr.length / 2 >= count) {
			res = -1;
		}
		return res;
	}

	public static int maxSlidingWindow(int[] arr, int k) {
		int curr = 0, res = 0;
		for (int i = 0; i < k; i++) {
			curr += arr[i];
		}
		res = curr;

		for (int i = k; i < arr.length; i++) {
			curr = curr + arr[i] - arr[i - k];
			res = Math.max(curr, res);
		}
		return res;

	}

	public static boolean isSubSum(int[] arr, int sum) {
		int s = 0, curr = 0;
		for (int i = 0; i < arr.length; i++) {
			curr += arr[i];
			while (sum < curr) {
				curr -= arr[s];
				s++;
			}
			if (curr == sum) {
				return true;
			}
		}
		return false;
	}

	public static int prefixSum(int[] arr, int s, int e) {
		int[] preSum = new int[arr.length];

		for (int i = 1; i < arr.length; i++) {
			preSum[i] += preSum[i - 1];
		}

		if (s == 0) {
			return preSum[e];
		}
		return preSum[e] - preSum[s - 1];
	}

	public static boolean equilibriumPoint(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int lm = 0, rm = 0;
			for (int j = 0; j < i; j++) {
				lm += arr[j];
			}
			for (int k = i + 1; k < arr.length; k++) {
				rm += arr[k];
			}

			if (lm == rm)
				return true;
		}
		return false;
	}

	public static boolean equilibriumPointEfficient(int[] arr) {
		int rs = 0;
		for (int i = 0; i < arr.length; i++) {
			rs += arr[i];
		}

		int ls = 0;
		for (int i = 0; i < arr.length; i++) {
			rs -= arr[i];
			if (ls == rs)
				return true;
			ls += arr[i];
		}
		return false;
	}

	public static int maxAppear(int[] l, int[] r) {
		int[] temp = new int[100];

		for (int i = 0; i < r.length; i++) {
			temp[l[i]]++;
			temp[r[i + 1]]--;
		}
		int res = 0;
		for (int i = 1; i < temp.length; i++) {
			temp[i] += temp[i - 1];
			if (temp[i] > temp[res]) {
				res = i;
			}
		}
		return res;

	}	
	
	public static void printSubSequence(int index, int[] arr, Stack<Integer> list) {
		if(index==arr.length) {
			for(int i =0;i<list.size();i++) {
				System.out.print(list.get(i));
			}
			System.out.println();
			return;
   		}
		list.push(arr[index]);
		printSubSequence(index+1 , arr, list);
		list.pop();
		printSubSequence(index+1,arr,list);
	}
	
	public static int printSubSequenceCount(int index, int[] arr, int sum, int s) {
		if(index==arr.length) {
			if(s==sum) return 1;
			else return 0;
   		}
		s+= arr[index];
		int l =printSubSequenceCount(index+1 , arr, sum , s);
		s-=arr[index];
		int r = printSubSequenceCount(index+1, arr, sum, s);
		
		return l+r;
	}
}

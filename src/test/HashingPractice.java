package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashingPractice {

	public static void main(String[] args) {
		System.out.println(countDistinct(new Integer[] { 12, 1, 23, 43, 43 }));

		printFreq(new int[] { 12, 1, 23, 43, 43 });
		
		System.out.println(computeCommonSum(new int[] {-1,1,0,1,0,-1},new int[] {-89,0,1,0,1,99}));
		
		System.out.println(longestConsecuive(new int[] {1,2,3,4,5,44,32,23}));
		
		System.out.println(distinctWindow(new int[] {11,12,13,14,12,12,12},4));

	}

	public static int countDistinct(Integer arr[]) {
		Set<Integer> mySet = new HashSet<>(Arrays.asList(arr));
		return mySet.size();
	}

	public static void printFreq(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		for (int i = 0; i < map.size(); i++) {
			System.out.println(arr[i] + "   " + map.get(arr[i]));
		}
	}

	public static boolean isSumPair(int[] arr, int sum) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(sum - arr[i])) {
				return true;
			}
			else {
				set.add(arr[i]);
			}
		}
		return false;
	}
	
	public static boolean isOsumArray(int arr[]) {
		int sumArray =0;
		Set<Integer> set = new HashSet<>();
//		se
		for(int i =0; i< arr.length;i++) {
			sumArray+=arr[i];
			if(set.contains(sumArray)) {
				return true;
			}
			if(sumArray==0) return true;
			set.add(arr[i]);
		}
		return false;
	}
	
	public static boolean isGivensumArray(int arr[],int sum) {
		int sumArray =0;
		Set<Integer> set = new HashSet<>();
		for(int i =0; i< arr.length;i++) {
			sumArray+=arr[i];
			if(sumArray==sum) return true;
			if(set.contains(sumArray-sum)) {
				return true;
			}
			
			set.add(arr[i]);
		}
		return false;
	}
	
	public static int lenLongSubArray(int[] arr,int sum) {
    		Map<Integer,Integer> map = new HashMap<>();
    		int preSum=0; int res=0;
    		for(int i=0;i<arr.length;i++) {
    			preSum+=arr[i];
    			if(preSum == sum) res = i+1;
    			if(!map.containsKey(preSum)) {
    				map.put(preSum, i);
    			}
    			if(map.containsKey(preSum-sum)) {
    				res = Math.max(res, i-map.get(preSum-sum));
    			}
    		}
    		return res;
	}

	public static int longestSubarraywith0sand1s(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}
		return lenLongSubArray(arr, 0);
	}
	
	public static int computeCommonSum(int[] arr1, int[] arr2) {
		int temp[] = new int[arr1.length];
		for(int i=0;i<arr1.length;i++) {
			temp[i] = arr1[i] - arr2[i];
		}
		return lenLongSubArray(temp,0);
	}
	
	public static int longestConsecuive(int[] arr1) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		int res = 1;
		for (Integer x : set) {
			if (!set.contains(x-1)) {
				int curr = 1;
				while (set.contains(x + curr)) {
					++curr;
				}
				res = Math.max(res, curr);
			}
		}
		return res;
	}

	public static List<Integer> distinctWindow(int[] arr,int k) {
		List<Integer> list = new ArrayList<>();
		Map<Integer,Integer> map = new  HashMap<>();
		for(int i=0;i<k;i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			
		}
		list.add(map.size());
		for(int i=k;i<arr.length;i++) {
			map.remove(arr[i-k]);
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			list.add(map.size());
		}
		return list;
	}
	
	
	
}

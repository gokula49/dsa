package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecursionPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		printOneToN(4);
//		System.out.println(fibb(6));
//		String str = "amojema";
//		System.out.println(strPalin(str,0,str.length()-1));
//		System.out.println(sumDigit(132));
		
//		System.out.println(ropeCutting(23,12,9,11));
//		subSetString("abc","",0);
		
		// Combination 1 Problem
		List<List<Integer>> list = combinationSum(new int[] {2,3,6,7},7);
		
		for(List<Integer> num : list) {
			System.out.println(num);
		}
		
		
	}
	
	public static void printOneToN(int n) {
		if(n==0) {
			return;
		}
		printOneToN(n-1);
		System.out.println(n);
	}
	
	public static int fact(int n) {
		if(n==1) {
			return 1;
		}
		
		return n * fact(n-1);
	}
	
	public static int fibb(int n) {
		if(n<2) {
			return n;
		}
		return fibb(n-1) + fibb(n-2);
	}
	
	public static boolean strPalin(String str, int s, int e) {
		if(s>e) {
			return true;
		}
		return str.charAt(s) == str.charAt(e) && strPalin(str,++s,--e);
	}
	
    // Important
	public static int sumDigit(int num) {
		if(num==0) return 0;
		return sumDigit(num/10) + num%10;
	}
	
	public static int ropeCutting(int n, int a , int b, int c) {
		
		if(n==0) {
			return 0;
		}
		if(n<0) {
			return -1;
		}
		
		int res =biggestOfThree(ropeCutting(n-a,a,b,c),ropeCutting(n-b,a,b,c),ropeCutting(n-c,a,b,c));
		
		if(res==-1) return -1;
		
		return res+1;
		
	}
	
	 static int biggestOfThree(int x, int y, int z)
	    {
	 
	        return z > (x > y ? x : y) ? z : ((x > y) ? x : y);
	    }
	 static ArrayList<String> list  = new ArrayList<>();
	 static void subSetString(String str, String curr, int n) {
		 if(n==str.length()) { 
			 System.out.println(curr);
			 return;
		 }
		 
		  subSetString(str,curr,n+1);
		  subSetString(str,curr + str.charAt(n),n+1);
	 }
//	 abc
	 
	 public static int dynamicSum(int[] arr, int sum, int n) {
		 if(n==0) return sum==0?1:0;
		 
		 return dynamicSum(arr,sum,n-1)+dynamicSum(arr,sum-arr[n-1],n-1);
 
	 }
	 
	 public static void towerOfHonoi(int n,char a, char b, char c) {
		 if(n==1) {
			 System.out.println("move 1 from " + a+"to"+c );
			 return;
		 }
		 towerOfHonoi(n-1,a , c, b);
		 System.out.println("move" + n+ "from" + a + "to" + c);
		 towerOfHonoi(n-1, b, a, c);
		 
	 }
	 
	 
//    Combination Sum – 1 
//	 
//	 
//	 Input: array = [2,3,6,7], target = 7
//
//     Output: [[2,2,3],[7]]
	 
	private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
		if (ind == arr.length) {
			if (target == 0) {
				ans.add(new ArrayList<>(ds));
			}
			return;
		}

		if (arr[ind] <= target) {
			ds.add(arr[ind]);
			findCombinations(ind, arr, target - arr[ind], ans, ds);
			ds.remove(ds.size() - 1);
		}
		findCombinations(ind + 1, arr, target, ans, ds);
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		findCombinations(0, candidates, target, ans, new ArrayList<>());
		return ans;
	}
	    
	    
//	    Combination Sum II – Find all unique combinations
//	    Input: candidates = [10,1,2,7,6,1,5], target = 8
//
//	    Output: 
//	    		[
//	    		[1,1,6],
//	    		[1,2,5],
//	    		[1,7],
//	    		[2,6]]
	    
	static void findCombinationss(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
		if (target == 0) {
			ans.add(new ArrayList<>(ds));
			return;
		}

		for (int i = ind; i < arr.length; i++) {
			if (i > ind && arr[i] == arr[i - 1])
				continue;
			if (arr[i] > target)
				break;

			ds.add(arr[i]);
			findCombinationss(i + 1, arr, target - arr[i], ans, ds);
			ds.remove(ds.size() - 1);
		}
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(candidates);
		findCombinationss(0, candidates, target, ans, new ArrayList<>());
		return ans;
	}
	    
	    
	
//	Subset Sum : Sum of all Subsets
//	
//	Input: N = 3, arr[] = {5,2,1}
//
//	Output: 0,1,2,3,5,6,7,8
	
	static void subsetSumsHelper(int ind, int sum, ArrayList < Integer > arr, int N, ArrayList < Integer > sumSubset) {
        if (ind == N) {
            sumSubset.add(sum);
            return;
        }

        // pick the element 
        subsetSumsHelper(ind + 1, sum + arr.get(ind), arr, N, sumSubset);

        // Do-not pick the element
        subsetSumsHelper(ind + 1, sum, arr, N, sumSubset);
    }

    static ArrayList < Integer > subsetSums(ArrayList < Integer > arr, int N) {

        ArrayList < Integer > sumSubset = new ArrayList < > ();
        subsetSumsHelper(0, 0, arr, N, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }
    
    
//    Subset – II | Print all the Unique Subsets 
    
//    Input: array[] = [1,2,2]
//
//    Output: [ [ ],[1],[1,2],[1,2,2],[2],[2,2] ]
 
    
    public static void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds)); 
        for(int i = ind;i<nums.length;i++) {
            if(i!=ind && nums[i] == nums[i-1]) continue; 
            ds.add(nums[i]); 
            findSubsets(i+1, nums, ds, ansList); 
            ds.remove(ds.size() - 1);
        }
        
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> ansList = new ArrayList<>(); 
        findSubsets(0, nums, new ArrayList<>(), ansList); 
        return ansList; 
    }
    
    
    // Permutation Problem 
    
    public static  void recursePermutation(int[] nums, List<Integer> ds ,List<List<Integer>> ans, boolean[] freq) {
    	if(ds.size() == nums.length) {
    		ans.add(new ArrayList<Integer>(ds));
    		return;
    	}
    	
    	for(int i=0;i<nums.length;i++) {
    		if(!freq[i]) {
    			ds.add(nums[i]);
    			freq[i] = true;
    			recursePermutation(nums,ds,ans,freq);
    			ds.remove(ds.size()-1);
    			freq[i]=  false;
    		}
    	}
    }
    
    
    public static List<List<Integer>>  purmutation(int[] nums) {
    	boolean[] freq = new boolean[nums.length];
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	recursePermutation(nums,new ArrayList<Integer>(),ans,freq);
    	return ans;
    	
    }
    
    
    
    // Permutation 2 Problem 
    
    public static void recurePermute(int index, int[] nums ,List<List<Integer>> ans) {
    	if(index== nums.length) {
    		List<Integer> list = new ArrayList<Integer>();
    		for(int i=0; i<nums.length;i++) {
    			list.add(nums[i]);
    		}
    		ans.add(new ArrayList<Integer>(list));
    	}
    	
    	for(int i=index; i<nums.length;i++) {
    		swap(i, index, nums);
    		recurePermute(index+1, nums, ans);
    		swap(i, index, nums);

    	}
    	
    }

	private static void swap(int i, int index, int[] nums) {
      int temp = nums[i];
      nums[i] = nums[index];
      nums[index] = temp;
		
		
	}
    
    
    
	    

}

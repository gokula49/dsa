package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DynamicProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(fibbRecursive(6));
//		
//		System.out.println(fibbMemoize(6, new int[7]));
//		
//		System.out.println(fibbTabula(6, new int[7]))l;
//		
//		System.out.println(fibbTabulaOptimization(6));
		int[] arr = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };

//		new int[] {7,1,5,3,6,4}
//
//		int wt[] = { 2, 4, 6 };
//		int val[] = { 5, 11, 13 };
//		String s1 = "fhrtytyinsnnsn";
//		String s2 = "kloabcdf";
//		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
//		 for (int[] row : dp)
//           Arrays.fill(row, -1);

//		System.out.println(unboundKnapsack(wt.length - 1, 10, wt, val));

//		 int W , int[] wt, int[] val , int[][] dp

//		System.out.println(unboundKnapsackTabulation(10,wt,val,dp));

//		System.out.println(maxSequence(s1, s2, s1.length() - 1, s2.length() - 1));

//		System.out.println(maxSequenceMemo(s1,s2,s1.length()-1,s2.length()-1, dp));

//		System.out.println(printMaxSequenceTabulation(s1, s2, dp));

//		System.out.println(minimumInsersionToMakeStringPalindrome(s1));

//		System.out.println(printMinSuberSequenceTabulation("broote","groote"));

//		System.err.println(distictSubsequenceinaString("abcdeavbc","abc",8,2));
//		System.out.println(distictSubsequenceTabulation("abcdeavbc","abc"));

		int dp[][] = new int[arr.length][arr.length + 1];

		for (int[] row : dp)
			Arrays.fill(row, -1);

//		System.out.println(minSupplyCoinMemoize(arr.length-1 ,7 , arr,dp));

//		System.out.println(minSupplyCoinTabulation(7,arr,dp));

//	    public static int minSupplyCoinTabulation(int total , int[] arr, int[][] dp) {

//		System.out.println(maxProfit2(0,true, new int[] {7,1,5,3,6,4}));

//		int dp[][] = new int[arr.length][7+1];

//		 for (int[] row : dp)
//	            Arrays.fill(row, -1);

//		System.out.println(maxProfit2Memoize(0,1, arr,dp));

//		maxProfitTabulation

		System.out.println(maxProfitTabulation(arr));

		System.out.println(maxProfitTabulationWithTransaction(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));

//		maxProfit2Memoize

//		longestIncreasingSubsequence

		System.out.println(longestIncreasingSubsequence(0, -1, new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));

		System.out.println(longestIncreasingSubsequenceMemoize(0, -1, arr, dp));

		System.out.println(longestIncreasingSubsequenceTabulation(arr));

		System.err.println(printLIs(arr));

		System.out.println(printLIs2(new String[] { "a", "b", "ba", "bca", "bda", "bdca" }));

//		System.out.println(palindromPartioning(0, "aabb") - 1);
//
//		System.out.println(palindromPartioningTabulation("aabb"));

	}

	public static int fibbRecursive(int n) {
		if (n <= 1)
			return n;

		return fibbRecursive(n - 1) + fibbRecursive(n - 2);
	}

	public static int fibbMemoize(int n, int[] arr) {
		if (n <= 1)
			return n;
		if (arr[n] != -1) {
			arr[n] = fibbMemoize(n - 1, arr) + fibbMemoize(n - 2, arr);
		}
		return arr[n];
	}

	public static int fibbTabula(int n, int[] arr) {
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		return arr[n];
	}

	public static int fibbTabulaOptimization(int n) {
		int prev2 = 0, prev = 1;
		int curr = 0;
		for (int i = 2; i <= n; i++) {
			curr = prev + prev2;
			prev2 = prev;
			prev = curr;

		}

		return prev;
	}

	// Recursive Solution
	// Minimum energy required to rech o th to nth stair
	public static int dogJumpProb(int[] energy, int index) {

		if (index <= 0)
			return 0;

		int left = dogJumpProb(energy, index - 1) + Math.abs(energy[index] - energy[index-1]);
		int right = 0;
		if (index > 1)
			right = dogJumpProb(energy, index - 2) + Math.abs(energy[index] - energy[index-2]);

		return Math.min(left, right);

	}

	// memoization solution

	public static int dogJumpProbMemoize(int[] arr, int index, int[] dp) {

		if (index <= 0)
			return 0;

		if (dp[index] != -1)
			return dp[index];

		int left = dogJumpProb(arr, index - 1) + Math.abs(arr[index] - arr[index - 1]);
		int right = 0;
		if (index > 1)
			right = dogJumpProb(arr, index - 2) + Math.abs(arr[index] - arr[index - 2]);


		return dp[index] = Math.min(left, right);

	}

	// Tabulation

	public static int dogJumpProbTabulaize(int[] arr, int index, int[] dp) {

		dp[0] = 0;

		for (int i = 1; i < arr.length; i++) {
			int fs = dp[i - 1] + Math.abs(arr[index] - arr[index - 1]);

			int ss = Integer.MAX_VALUE;

			if (index > 1) {
				ss = dp[i - 2] + Math.abs(arr[index] - arr[index - 2]);
			}

			dp[index] = Math.min(fs, ss);
		}

		return dp[dp.length - 1];

	}

	// Dog Jump K steps
	public static int dogJumpKSteps(int[] arr, int k, int index) {

		if (index == 0)
			return 0;

		int minSteps = Integer.MAX_VALUE;

		for (int i = 1; i < k; i++) {
			if (index - i <= 0) {
				int jums = dogJumpKSteps(arr, k, index - i) + Math.abs(arr[index] - arr[index-i]);
				minSteps = Math.min(minSteps, jums);
			}
		}

		return minSteps;

	}

	// Recursive approch
	public static int maximumNonAdjacentSum(int[] arr, int index) {
		if (index == 0)
			return arr[index];
		if (index < 0)
			return 0;
		return Math.max(0 + maximumNonAdjacentSum(arr, index - 1), arr[index] + maximumNonAdjacentSum(arr, index - 2));
	}

	public static int maximumNonAdjacentSumMemoize(int[] arr, int index, int dp[]) {
		if (index == 0)
			return arr[index];
		if (index < 0)
			return 0;
		if (dp[index] != -1)
			return dp[index];
		return dp[index] = Math.max(0 + maximumNonAdjacentSumMemoize(arr, index - 1, dp),
				arr[index] + maximumNonAdjacentSumMemoize(arr, index - 2, dp));
	}

	public static int maximumNonAdjacentSumTabulation(int[] arr, int[] dp) {

		dp[0] = arr[0];
		int take, nonTake;

		for (int i = 1; i < arr.length; i++) {
			take = arr[i];
			if (i > 1)
				take += dp[i - 2];
			nonTake = 0 + dp[i - 1];
			dp[i] = Math.max(take, nonTake);

		}

		return dp[arr.length - 1];
	}

	public static int ninjaProblem(int[][] points, int last, int day) {
		int maxi = 0;
		if (day == 0) {
			for (int task = 0; task < 3; task++) {
				if (task != last) {
					maxi = Math.max(maxi, points[0][task]);
				}
			}
			return maxi;
		}

		maxi = 0;
		int point = 0;
		for (int task = 0; task < 3; task++) {
			if (last != task) {
				point = points[day][task] + ninjaProblem(points, task, day - 1);
				maxi = Math.max(point, maxi);
			}
		}
		return maxi;
	}

	// Memoization
	public static int ninjaProblemMemoize(int[][] points, int last, int day, int[][] dp) {
		int maxi = 0;
		if (day == 0) {
			for (int task = 0; task < 3; task++) {
				if (task != last) {
					maxi = Math.max(maxi, points[0][task]);
				}
			}
			return maxi;
		}

		maxi = 0;
		int point = 0;
		for (int task = 0; task < 3; task++) {
			if (dp[day][last] != -1)
				return dp[day][last];

			if (last != task) {
				point = points[day][task] + ninjaProblem(points, task, day - 1);
				dp[day][last] = Math.max(point, maxi);
			}
		}
		return dp[day][last];
	}

	// Tabulation
	public static int ninjaProblemTabulation(int[][] points, int[][] dp) {
		dp[0][0] = Math.max(points[0][1], points[0][2]);
		dp[0][1] = Math.max(points[0][2], points[0][0]);
		dp[0][2] = Math.max(points[0][0], points[0][1]);
		dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
		for (int day = 1; day < dp.length; day++) {
			for (int last = 0; last < 4; last++) {
				dp[day][last] = 0;

				for (int task = 0; task < 3; task++) {
					if (last != task) {
						int point = points[day][task] + dp[day - 1][task];
						dp[day][last] = Math.max(point, dp[day][last]);
					}
				}
			}
		}

		return dp[dp.length - 1][3];
	}

	// Unique Path Problem
	public static int uniqPath(int i, int j) {
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;

		return uniqPath(i - 1, j) + uniqPath(i, j - 1);
	}

	// Memoization
	public static int uniqPathMemo(int i, int j, int[][] dp) {
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		dp[i][j] = uniqPath(i - 1, j) + uniqPath(i, j - 1);

		return dp[j][j];
	}

	// Tabulation
	public static int uniquePathTabulation(int m, int n, int[][] dp) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					dp[i][j] = 1;
				else {
					int up = i > 0 ? dp[i - 1][j] : 0;
					int left = j > 0 ? dp[i][j - 1] : 0;
					dp[i][j] = up + left;
				}
			}
		}
		return dp[m - 1][n - 1];
	}

	// Recursion
	public static int gridMin(int i, int j, int[][] grid) {
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;

		int up = grid[i][j];
		int left = grid[i][j];
		if (i > 0)
			up += gridMin(i, j - 1, grid);
		if (j > 0)
			left += gridMin(i - 1, j, grid);

		return Math.min(up, left);
	}

	// Memoization
	public static int gridMin(int i, int j, int[][] grid, int[][] dp) {

		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int up = grid[i][j];
		int left = grid[i][j];
		if (i > 0)
			up += gridMin(i, j - 1, grid);
		if (j > 0)
			left += gridMin(i - 1, j, grid);

		return dp[i][j] = Math.min(up, left);

	}

	// Tabulation

	public static int gridTabulation(int[][] grid, int[][] dp) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0)
					dp[i][j] = 1;
				int up = grid[i][j];
				int left = grid[i][j];
				if (i > 0)
					up += dp[i][j - 1];
				else
					up += Integer.MAX_VALUE;
				if (j > 0)
					left += dp[i - 1][j];
				else
					left += Integer.MAX_VALUE;
				dp[i][j] = Math.min(left, up);
			}
		}
		return dp[dp.length - 1][dp.length - 1];
	}

	// Triangle variable points
	// we can move only down or diagonal need to find the minimum length to reach
	// n-1
	// Recursion

	public static int minRec(int i, int j, int[][] triangle) {
		if (i == triangle.length) {
			return triangle[triangle.length - 1][j];
		}

		int d = triangle[i][j] + minRec(i + 1, j, triangle);
		int dg = triangle[i][j] + minRec(i + 1, j + 1, triangle);

		return Math.max(d, dg);

	}

	public static int minRecMemoize(int i, int j, int[][] triangle, int[][] dp) {
		if (i == triangle.length) {
			return triangle[triangle.length - 1][j];
		}

		if (dp[i][j] != -1)
			return dp[i][j];
		int d = triangle[i][j] + minRec(i + 1, j, triangle);
		int dg = triangle[i][j] + minRec(i + 1, j + 1, triangle);

		return dp[i][j] = Math.max(d, dg);

	}

	public static int minRecTabulation(int[][] triangle, int[][] dp) {
		for (int j = 0; j < dp[dp.length - 1].length; j++)
			dp[dp.length - 1][j] = triangle[triangle.length - 1][j];

		for (int i = dp.length - 2; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				int d = triangle[i][j] + dp[i + 1][j];
				int dg = triangle[i][j] + dp[i + 1][j + 1];
				dp[i][j] = Math.min(d, dg);
			}
		}
		return dp[0][0];
	}

	public static int maxPathSum(int i, int j, int[][] mat) {
		if (j > mat.length - 1 || j < 0)
			return Integer.MIN_VALUE;

		if (i == 0)
			return mat[0][j];

		int d = mat[i][j] + maxPathSum(i - 1, j, mat);
		int rdl = mat[i][j] + maxPathSum(i - 1, j - 1, mat);
		int ldl = mat[i][j] + maxPathSum(i - 1, j + 1, mat);

		return Math.max(d, Math.max(rdl, ldl));

	}

	// array Subset Problem Recursion
	public static boolean subSetSum(int target, int[] arr, int index) {
		if (target == 0) {
			return true;
		}
		if (index == 0)
			return arr[0] == target;

		boolean notTake = subSetSum(target, arr, index - 1);
		boolean take = false;
		if (arr[index] <= target) {
			take = subSetSum(target - arr[index], arr, index);
		}

		return take || notTake;
	}

	// array Subset problem memoization
	public static int subSetSumMemoize(int target, int[] arr, int index, int dp[][]) {
		if (target == 0) {
			return 1;
		}
		if (index == 0) {
			if (arr[0] == target)
				return 1;
		} else
			return 0;

		int notTake = subSetSumMemoize(target, arr, index - 1, dp);
		int take = 0;
		if (arr[index] <= target) {
			take = subSetSumMemoize(target - arr[index], arr, index, dp);
		}

		return dp[index][target] = (take == 1 || notTake == 1) ? 1 : 0;
	}

	// Tabulation
	public static boolean subSet(int k, int[] arr, boolean dp[][]) {
		for (int i = 0; i < arr.length; i++)
			dp[i][0] = true;

		dp[0][arr[0]] = true;

		for (int i = 1; i < arr.length; i++) {
			for (int target = 1; target <= k; target++) {
				boolean notTake = dp[i - 1][target];
				boolean take = false;
				if (arr[i] <= target) {
					take = dp[i][target - arr[i]];
				}

				dp[i][target] = take || notTake;
			}
		}
		return dp[dp.length - 1][k];
	}

	// Recursion for count Number of subsets
	public static int countSubset(int[] arr, int target, int index) {
		if (target == 0)
			return 1;
		if (index == 0) {
			if (arr[index] == target)
				return 1;
			else
				return 0;
		}

		int notTake = countSubset(arr, target, index - 1);
		int take = 0;
		if (arr[index] <= target) {
			take = countSubset(arr, target - arr[index], index - 1);
		}

		return take + notTake;
	}

	// Memoize
	public static int countSubsetMemoize(int[] arr, int target, int index, int[][] dp) {
		if (target == 0)
			return 1;
		if (index == 0) {
			if (arr[index] == target)
				return 1;
			else
				return 0;
		}

		if (dp[index][target] != -1)
			return dp[index][target];

		int notTake = countSubset(arr, target, index - 1);
		int take = 0;
		if (arr[index] <= target) {
			take = countSubset(arr, target - arr[index], index - 1);
		}

		return dp[index][target] = take + notTake;
	}

	// Tabulation
	public static int countSubsetTabulation(int[] arr, int target) {
		int[][] dp = new int[arr.length][target + 1];

		for (int i = 0; i < arr.length; i++)
			dp[i][0] = 1;

		dp[0][arr[0]] = 1;

		for (int i = 1; i < arr.length; i++) {
			for (int k = 1; k < target; k++) {

				int notTake = dp[i - 1][target];
				int take = 0;
				if (arr[i] <= target) {
					take = dp[i - 1][target - arr[i]];
				}

				dp[i][k] = take + notTake;

			}
		}
		return dp[arr.length][target];
	}

	// knapsack Recursion
	public static int knapsackProblem(int ind, int w, int[] wt, int[] val) {
		if (ind == 0) {
			if (wt[0] <= w)
				return val[0];
			else
				return 0;
		}

		int notTake = 0 + knapsackProblem(ind - 1, w, wt, val);

		int take = 0;

		if (wt[ind] <= w) {
			take = val[ind] + knapsackProblem(ind - 1, w - wt[ind], wt, val);
		}
		return Math.max(notTake, take);

	}

	// Memoization
	public static int knapsackProblemDp(int ind, int w, int[] wt, int[] val, int[][] dp) {
		if (ind == 0) {
			if (wt[0] <= w)
				return val[0];
			else
				return 0;
		}
		if (dp[ind][w] != -1)
			return dp[ind][w];
		int notTake = 0 + knapsackProblem(ind - 1, w, wt, val);

		int take = 0;

		if (wt[ind] <= w) {
			take = val[ind] + knapsackProblem(ind - 1, w - wt[ind], wt, val);
		}
		return dp[ind][w] = Math.max(notTake, take);

	}

	// Tabulation
	public static int knapsackProblemDpTabulation(int maxW, int[] wt, int[] val) {
		int[][] dp = new int[wt.length][maxW + 1];
		for (int w = wt[0]; w < maxW; w++) {
			dp[w][0] = val[0];
		}

		for (int ind = 1; ind < wt.length; ind++) {
			for (int w = 1; w <= maxW; maxW++) {
				int notTake = 0 + dp[ind - 1][w];

				int take = 0;

				if (wt[ind] <= w) {
					take = val[ind] + dp[ind - 1][w - wt[ind]];
				}
				dp[ind][w] = Math.max(notTake, take);

			}
		}

		return dp[wt.length - 1][maxW];

	}

	// minimum coin with Infinite supply
	public static int minSupplyCoin(int ind, int total, int[] arr) {

		if (ind == 0) {
			if (arr[0] % total == 0)
				return arr[0] / total;
			else
				return 10000;
		}

		int notTake = 0 + minSupplyCoin(ind - 1, total, arr);

		int take = 10000;
		if (arr[ind] < total)
			take = 1 + minSupplyCoin(ind, total - arr[ind], arr);

		return Math.min(notTake, take);
	}

	// minimum coin with Infinite supply
	public static int minSupplyCoinMemoize(int ind, int total, int[] arr, int[][] dp) {

		if (ind == 0) {
			if (arr[0] % total == 0)
				return arr[0] / total;
			else
				return 10000;
		}

		if (dp[ind][total] != -1)
			return dp[ind][total];

		int notTake = 0 + minSupplyCoinMemoize(ind - 1, total, arr, dp);

		int take = 10000;
		if (arr[ind] < total)
			take = 1 + minSupplyCoinMemoize(ind, total - arr[ind], arr, dp);

		return dp[ind][total] = Math.min(notTake, take);
	}

	// minimum coin with Infinite supply
	public static int minSupplyCoinTabulation(int total, int[] arr, int[][] dp) {

		for (int i = 0; i <= total; i++) {
			if (i % arr[0] == 0)
				dp[0][i] = i / arr[0];
		}

		for (int index = 1; index < arr.length; index++) {
			for (int tot = 0; tot <= total; tot++) {
				int notTake = 0 + dp[index - 1][tot];
				int take = 10000;
				if (arr[index] < tot)
					take = 1 + dp[index][tot - arr[index]];

				dp[index][tot] = Math.min(notTake, take);
			}
		}

		return dp[arr.length - 1][total];

	}

	// Recursion
	public static int targetCoinSupply(int ind, int target, int[] arr) {

		if (ind == 0) {
			if (target % arr[0] == 0)
				return 1;
			else
				return 0;
		}

		int nontake = targetCoinSupply(ind - 1, target, arr);

		int take = 0;

		if (arr[ind] <= target)
			take = targetCoinSupply(ind, target - arr[ind], arr);

		return nontake + take;

	}

	// Memoization
	public static int targetCoinSupplyMemo(int ind, int target, int[] arr, int[][] dp) {

		if (ind == 0) {
			if (target % arr[0] == 0)
				return 1;
			else
				return 0;
		}

		if (dp[ind][target] != -1)
			return dp[ind][target];

		int nontake = targetCoinSupplyMemo(ind - 1, target, arr, dp);

		int take = 0;

		if (arr[ind] <= target)
			take = targetCoinSupplyMemo(ind, target - arr[ind], arr, dp);

		return dp[ind][target] = nontake + take;

	}

	public static int targetCoinSupplyTabulation(int target, int[] arr, int[][] dp) {
		for (int t = 0; t <= target; t++) {
			if (t % arr[0] == 0)
				dp[0][t] = 1;
		}
		for (int ind = 1; ind < arr.length; ind++) {
			for (int tar = 0; tar <= target; tar++) {
				int nontake = dp[ind - 1][tar];
				int take = 0;
				if (arr[ind] <= tar)
					take = dp[ind][tar - arr[ind]];

				dp[ind][tar] = nontake + take;
			}
		}
		return dp[arr.length - 1][target];
	}

	// Recursive solution for unbound knapsack problem
	public static int unboundKnapsack(int ind, int w, int[] wt, int[] val) {

		if (ind == 0) {
			if (w >= wt[0])
				return w / wt[0] * val[0];
			else
				return 0;
		}

		int notTake = 0 + unboundKnapsack(ind - 1, w, wt, val);
		int take = Integer.MIN_VALUE;
		if (wt[ind] <= w)
			take = val[ind] + unboundKnapsack(ind, w - wt[ind], wt, val);

		return Math.max(take, notTake);
	}

	// Memoization solution for unbound knapsack problem
	public static int unboundKnapsackMemoize(int ind, int w, int[] wt, int[] val, int[][] dp) {

		if (ind == 0) {
			if (w >= wt[0])
				return w / wt[0] * val[0];
			else
				return 0;
		}
		if (dp[ind][w] != -1)
			return dp[ind][w];

		int notTake = 0 + unboundKnapsack(ind - 1, w, wt, val);
		int take = Integer.MIN_VALUE;
		if (wt[ind] <= w)
			take = val[ind] + unboundKnapsack(ind, w - wt[ind], wt, val);

		return dp[ind][w] = Math.max(take, notTake);
	}

	// Tabulation solution for unbound knapsack problem
	public static int unboundKnapsackTabulation(int W, int[] wt, int[] val, int[][] dp) {

		for (int w = 0; w <= W; w++) {
			dp[0][w] = w / wt[0] * val[0];
		}
		for (int ind = 1; ind < wt.length; ind++) {
			for (int wt1 = 0; wt1 <= W; wt1++) {
				int notTake = 0 + dp[ind - 1][wt1];
				int take = 0;
				if (wt[ind] <= wt1)
					take = val[ind] + dp[ind][wt1 - wt[ind]];
				dp[ind][wt1] = Math.max(notTake, take);
			}

		}

		return dp[wt.length - 1][W];
	}

	// Recursion String longest maximum consequence
	public static int maxSequence(String s1, String s2, int i, int j) {
		if (i < 0 || j < 0)
			return 0;

		if (s1.charAt(i) == s2.charAt(j))
			return 1 + maxSequence(s1, s2, i - 1, j - 1);

		return 0 + Math.max(maxSequence(s1, s2, i - 1, j), maxSequence(s1, s2, i, j - 1));
	}

	// Memoization
	public static int maxSequenceMemo(String s1, String s2, int i, int j, int[][] dp) {
		if (i < 0 || j < 0)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		if (s1.charAt(i) == s2.charAt(j))
			return 1 + maxSequence(s1, s2, i - 1, j - 1);

		return dp[i][j] = 0 + Math.max(maxSequence(s1, s2, i - 1, j), maxSequence(s1, s2, i, j - 1));
	}

	// Tabulation
	public static int maxSequenceTabulation(String s1, String s2, int[][] dp) {

		for (int i1 = 0; i1 <= s1.length(); i1++) {
			dp[i1][0] = 0;
		}
		for (int j1 = 0; j1 <= s2.length(); j1++) {
			dp[0][j1] = 0;
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[s1.length()][s2.length()];

	}

	public static int maxSubStringTabulation(String s1, String s2, int[][] dp) {

		for (int i1 = 0; i1 <= s1.length(); i1++) {
			dp[i1][0] = 0;
		}
		for (int j1 = 0; j1 <= s2.length(); j1++) {
			dp[0][j1] = 0;
		}

		int ans = 0;

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					ans = Math.max(ans, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}

		return ans;

	}

	public static String printMaxSequenceTabulation(String s1, String s2, int[][] dp) {
		for (int i1 = 0; i1 <= s1.length(); i1++) {
			dp[i1][0] = 0;
		}
		for (int j1 = 0; j1 <= s2.length(); j1++) {
			dp[0][j1] = 0;
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int m = s1.length();
		int n = s2.length();
		String ans = "";
		while (m > 0 && n > 0) {
			if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
				ans = s1.charAt(m - 1) + ans;
				m--;
				n--;
			}

			else if (dp[m - 1][n] > dp[m][n - 1]) {
				m--;
			} else {
				n--;
			}
		}
		return ans;
	}

	public static String longestPalindramicSubsequence(String s) {
		int[][] dp = new int[s.length() + 1][s.length() + 1];
		StringBuilder str = new StringBuilder(s);
		return printMaxSequenceTabulation(s, str.reverse().toString(), dp);
	}

	public static int lengthOfLongestPalindramicSubsequence(String s) {
		int[][] dp = new int[s.length() + 1][s.length() + 1];
		StringBuilder str = new StringBuilder(s);
		return maxSequenceTabulation(s, str.reverse().toString(), dp);
	}

	public static int minimumInsersionToMakeStringPalindrome(String s) {
		return s.length() - lengthOfLongestPalindramicSubsequence(s);
	}

	public static int minimInsersiontoMakeStringS1toS2(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		return s1.length() + s2.length() - 2 * maxSequenceTabulation(s1, s2, dp);
	}

	public static String printMinSuberSequenceTabulation(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i1 = 0; i1 <= s1.length(); i1++) {
			dp[i1][0] = 0;
		}
		for (int j1 = 0; j1 <= s2.length(); j1++) {
			dp[0][j1] = 0;
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int m = s1.length();
		int n = s2.length();
		String ans = "";
		while (m > 0 && n > 0) {
			if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
				ans = s1.charAt(m - 1) + ans;
				m--;
				n--;
			}

			else if (dp[m - 1][n] > dp[m][n - 1]) {
				ans = s1.charAt(m - 1) + ans;
				m--;
			} else {
				ans = s2.charAt(n - 1) + ans;
				n--;
			}
		}

		while (m > 0) {
			ans = s1.charAt(m - 1) + ans;
			m--;
		}

		while (n > 0) {
			ans = s2.charAt(n - 1) + ans;
			n--;
		}
//		StringBuilder st = new StringBuilder(ans);

		return ans;
	}

	// Recursion
	public static int distictSubsequenceinaString(String s1, String s2, int m, int n) {
		if (n <= 0)
			return 1;
		if (m <= 0)
			return 0;

		if (s1.charAt(m) == s2.charAt(n)) {
			return distictSubsequenceinaString(s1, s2, m - 1, n - 1) + distictSubsequenceinaString(s1, s2, m - 1, n);
		}

		return distictSubsequenceinaString(s1, s2, m - 1, n);
	}

	public static int distictSubsequenceTabulation(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int n = 0; n <= s1.length(); n++) {
			dp[n][0] = 1;
		}

		for (int m = 1; m <= s2.length(); m++) {
			dp[0][m] = 0;
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}

	// Recursion
	public static int editDistance(String s1, String s2, int m, int n) {
		if (m < 0)
			return n + 1;
		if (n < 0)
			return m + 1;

		if (s1.charAt(m) == s2.charAt(n))
			return 0 + editDistance(s1, s2, m - 1, n - 1);

		return 1 + Math.min(editDistance(s1, s2, m - 1, n),
				Math.min(editDistance(s1, s2, m, n - 1), editDistance(s1, s2, m - 1, n - 1)));
	}

	// Memoization
	public static int editDistance(String s1, String s2, int m, int n, int[][] dp) {
		if (m < 0)
			return n + 1;
		if (n < 0)
			return m + 1;
		if (dp[m][n] != -1)
			return dp[m][n];
		if (s1.charAt(m) == s2.charAt(n))
			return dp[m][n] = 0 + editDistance(s1, s2, m - 1, n - 1);

		return dp[m][n] = 1 + Math.min(editDistance(s1, s2, m - 1, n),
				Math.min(editDistance(s1, s2, m, n - 1), editDistance(s1, s2, m - 1, n - 1)));
	}

	public static int editDistance(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= m; i++) {
			dp[0][i] = i + 1;
		}

		for (int j = 0; j <= n; j++) {
			dp[j][0] = j + 1;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i) == s2.charAt(i))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[m - 1][n], Math.min(dp[m][n - 1], dp[m - 1][n - 1]));
			}
		}

		return dp[m][n];
	}

	// Stok buy and sell problem part 1
	public static int maxProfit(int[] arr) {
		int mini = arr[0];
		int maxProfit = 0;
		for (int i = 1; i < arr.length; i++) {
			maxProfit = Math.max(maxProfit, arr[i] - mini);
			mini = Math.min(mini, arr[i]);
		}
		return mini;

	}

	public static int maxProfit2(int ind, boolean buy, int[] stocks) {
		if (ind == stocks.length)
			return 0;

		int profit = 0;

		if (buy) {
			profit = Math.max(-stocks[ind] + maxProfit2(ind + 1, false, stocks), 0 + maxProfit2(ind + 1, true, stocks));
		} else {
			profit = Math.max(stocks[ind] + maxProfit2(ind + 1, true, stocks), 0 + maxProfit2(ind + 1, false, stocks));
		}
		return profit;
	}

	public static int maxProfit2Memoize(int ind, int buy, int[] stocks, int[][] dp) {
		if (ind == stocks.length)
			return 0;
		if (dp[ind][buy] != -1)
			return dp[ind][buy];
		if (buy == 1) {
			dp[ind][buy] = Math.max(-stocks[ind] + maxProfit2Memoize(ind + 1, 0, stocks, dp),
					0 + maxProfit2Memoize(ind + 1, 1, stocks, dp));
		} else {
			dp[ind][buy] = Math.max(stocks[ind] + maxProfit2Memoize(ind + 1, 1, stocks, dp),
					0 + maxProfit2Memoize(ind + 1, 0, stocks, dp));
		}
		return dp[ind][buy];
	}

	public static int maxProfitTabulation(int[] stocks) {
		int dp[][] = new int[stocks.length + 1][3];
		for (int ind = stocks.length - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 1) {
					dp[ind][buy] = Math.max(-stocks[ind] + dp[ind + 1][0], 0 + dp[ind + 1][1]);
				} else {
					dp[ind][buy] = Math.max(stocks[ind] + dp[ind + 1][1], dp[ind + 1][0]);
				}
			}
		}
		return dp[0][1];
	}

	// Stock buy and sell problem with transaction
	public static int maxProfit2WithTrasanction(int ind, boolean buy, int[] stocks, int trans) {
		if (ind == stocks.length || trans == 0)
			return 0;

		int profit = 0;

		if (buy) {
			profit = Math.max(-stocks[ind] + maxProfit2WithTrasanction(ind + 1, false, stocks, trans),
					0 + maxProfit2WithTrasanction(ind + 1, true, stocks, trans));
		} else {
			profit = Math.max(stocks[ind] + maxProfit2WithTrasanction(ind + 1, true, stocks, trans - 1),
					0 + maxProfit2WithTrasanction(ind + 1, false, stocks, trans));
		}
		return profit;
	}

	// Stock buy and sell problem with transaction
	public static int maxProfitTabulationWithTransaction(int[] stocks) {
		int dp[][][] = new int[stocks.length + 1][2][3];
		for (int ind = stocks.length - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				for (int tranc = 1; tranc <= 2; tranc++) {

					if (buy == 1) {
						dp[ind][buy][tranc] = Math.max(-stocks[ind] + dp[ind + 1][0][tranc], 0 + dp[ind + 1][1][tranc]);
					} else {
						dp[ind][buy][tranc] = Math.max(stocks[ind] + dp[ind + 1][1][tranc - 1],
								0 + dp[ind + 1][0][tranc]);
					}
				}
			}
		}
		return dp[0][1][2];
	}

	public static int longestIncreasingSubsequence(int ind, int prev_ind, int[] arr) {
		if (ind == arr.length) {
			return 0;
		}

		int len = 0 + longestIncreasingSubsequence(ind + 1, prev_ind, arr);

		if (prev_ind == -1 || arr[ind] > arr[prev_ind]) {
			len = Math.max(1 + longestIncreasingSubsequence(ind + 1, ind, arr), len);
		}

		return len;
	}

	public static int longestIncreasingSubsequenceMemoize(int ind, int prev_ind, int[] arr, int[][] dp) {
		if (ind == arr.length) {
			return 0;
		}
		if (dp[ind][prev_ind + 1] != -1)
			return dp[ind][prev_ind + 1];

		int len = 0 + longestIncreasingSubsequenceMemoize(ind + 1, prev_ind, arr, dp);

		if (prev_ind == -1 || arr[ind] > arr[prev_ind]) {
			len = Math.max(1 + longestIncreasingSubsequenceMemoize(ind + 1, ind, arr, dp), len);
		}

		return dp[ind][prev_ind + 1] = len;
	}

	public static int longestIncreasingSubsequenceTabulation(int[] arr) {
		int maxi = 0;

		int[] dp = new int[arr.length];

		Arrays.fill(dp, 1);

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[i] + 1 > dp[i]) {
					dp[i] = 1 + dp[j];
				}
			}
			maxi = Math.max(maxi, dp[i]);
		}

		return maxi;
	}

	public static int printLIs(int[] arr) {
		int maxi = 0;
		int[] hash = new int[arr.length];

		int[] dp = new int[arr.length];
		int maxiInd = 0;

		for (int i = 1; i < arr.length; i++) {
			hash[i] = i;
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[i] + 1 > dp[i]) {
					dp[i] = 1 + dp[j];
					hash[i] = j;
				}
			}
			if (maxi != dp[i]) {
				maxi = Math.max(maxi, dp[i]);
				maxiInd = i;
			}
		}

		System.out.println("LIS Started");

		while (hash[maxiInd] != maxiInd) {

			System.out.println(arr[maxiInd]);
			maxiInd = hash[maxiInd];
		}
		System.out.println(hash[maxi]);

		System.out.println("LIS Ended");

		return 0;
	}

	public static boolean checkPossibilities(String s1, String s2) {

		if (s1.length() != s2.length() + 1)
			return false;

		int first = 0, second = 0;

		while (first < s1.length()) {
			if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
				first++;
				second++;
			} else {
				first++;
			}
		}

		if (s1.length() == first && s2.length() == second)
			return true;
		return false;

	}

	// longest String chain
	public static int printLIs2(String[] str) {
		Arrays.sort(str, Comparator.comparing(s -> s.length()));
		for (String s1 : str) {
			System.out.println(s1);
		}
		int maxi = 1;
		int[] dp = new int[str.length];
		Arrays.fill(dp, 1);
		for (int i = 1; i < str.length; i++) {
			for (int j = 0; j < i; j++) {
				if (checkPossibilities(str[i], str[j]) && dp[j] + 1 > dp[i]) {
					dp[i] = 1 + dp[j];
				}
			}
			maxi = Math.max(maxi, dp[i]);

		}

		return maxi;
	}

}

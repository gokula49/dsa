package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Backtracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// MErge Sort
	public static void mergeSort(int[] arr, int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;
		mergeSort(arr, low, mid); // left half
		mergeSort(arr, mid + 1, high); // right half
		merge(arr, low, mid, high); // merging sorted halves
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		ArrayList<Integer> temp = new ArrayList<>(); // temporary array
		int left = low; // starting index of left half of arr
		int right = mid + 1; // starting index of right half of arr

		// storing elements in the temporary array in a sorted manner//

		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) {
				temp.add(arr[left]);
				left++;
			} else {
				temp.add(arr[right]);
				right++;
			}
		}

		// if elements on the left half are still left //

		while (left <= mid) {
			temp.add(arr[left]);
			left++;
		}

		// if elements on the right half are still left //
		while (right <= high) {
			temp.add(arr[right]);
			right++;
		}

		// transfering all elements from temporary to arr //
		for (int i = low; i <= high; i++) {
			arr[i] = temp.get(i - low);
		}
	}

	// Quick Sort

	static int partition(List<Integer> arr, int low, int high) {
		int pivot = arr.get(low);
		int i = low;
		int j = high;

		while (i < j) {
			while (arr.get(i) <= pivot && i <= high - 1) {
				i++;
			}

			while (arr.get(j) > pivot && j >= low + 1) {
				j--;
			}
			if (i < j) {
				int temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
			}
		}
		int temp = arr.get(low);
		arr.set(low, arr.get(j));
		arr.set(j, temp);
		return j;
	}

	static void qs(List<Integer> arr, int low, int high) {
		if (low < high) {
			int pIndex = partition(arr, low, high);
			qs(arr, low, pIndex - 1);
			qs(arr, pIndex + 1, high);
		}
	}

	public static List<Integer> quickSort(List<Integer> arr) {
		// Write your code here.
		qs(arr, 0, arr.size() - 1);
		return arr;
	}

	
	//solveSudoku
	
	public static boolean solveSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {

					for (char c = '1'; c <= '9'; c++) {
						if (isValid(board, i, j, c)) {
							board[i][j] = c;

							if (solveSudoku(board))
								return true;
							else
								board[i][j] = '.';
						}
					}

					return false;
				}
			}
		}
		return true;
	}

	public static boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == c)
				return false;

			if (board[row][i] == c)
				return false;

			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
				return false;
		}
		return true;
	}

	
	// Rat in a Maz
	
	private static void solve(int i, int j, int a[][], int n, ArrayList<String> ans, String move, int vis[][]) {
		if (i == n - 1 && j == n - 1) {
			ans.add(move);
			return;
		}

		// downward
		if (i + 1 < n && vis[i + 1][j] == 0 && a[i + 1][j] == 1) {
			vis[i][j] = 1;
			solve(i + 1, j, a, n, ans, move + 'D', vis);
			vis[i][j] = 0;
		}

		// left
		if (j - 1 >= 0 && vis[i][j - 1] == 0 && a[i][j - 1] == 1) {
			vis[i][j] = 1;
			solve(i, j - 1, a, n, ans, move + 'L', vis);
			vis[i][j] = 0;
		}

		// right
		if (j + 1 < n && vis[i][j + 1] == 0 && a[i][j + 1] == 1) {
			vis[i][j] = 1;
			solve(i, j + 1, a, n, ans, move + 'R', vis);
			vis[i][j] = 0;
		}

		// upward
		if (i - 1 >= 0 && vis[i - 1][j] == 0 && a[i - 1][j] == 1) {
			vis[i][j] = 1;
			solve(i - 1, j, a, n, ans, move + 'U', vis);
			vis[i][j] = 0;
		}
	}

	public static ArrayList<String> findPath(int[][] m, int n) {
		int vis[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				vis[i][j] = 0;
			}
		}

		ArrayList<String> ans = new ArrayList<>();
		if (m[0][0] == 1)
			solve(0, 0, m, n, ans, "", vis);
		return ans;
	}

	
	// N Queens
 	
	public static List < List < String >> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < List < String >> ();
        dfs(0, board, res);
        return res;
    }

    static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }

    static void dfs(int col, char[][] board, List < List < String >> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }



    static List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}

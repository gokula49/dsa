package test;


public class MatrixProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void printMatrixSnackPattern(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			if(i%2==0) {
				for(int j=0;i<arr[i].length;j++) {
					System.out.println(arr[i][j] + " ");
				}	
			}else {
				for(int j=arr[i].length-1;j>=0;j--) {
					System.out.println(arr[i][j]);
				}
			}
			
		}
	}
	
	public static void printMatrixBoudries(int arr[][]) {
		if(arr.length == 1) {
			for(int i=0;i<arr[i].length;i++) {
				System.out.println(arr[0][i]);
			}
		}else if(arr[0].length==1) {
			for(int i =0;i<arr.length;i++)
    			System.out.println(arr[i][0]);
		}else {
			for(int i=0;i<arr[0].length;i++) {
				System.out.println(arr[0][i]);
			}
			for(int i=1;i<arr.length;i++) {
				System.out.println(arr[i][arr[i].length-1]);
			}
			for(int i=arr[0].length-2;i>=0;i++) {
				System.out.println(arr[arr.length-1][i]);
			}
			for(int i=arr.length-2;i>=1;i--) {
				System.out.println(arr[i][0]);
			}
		}
	}
	
	public static void printTransepose(int mat[][]) {
		for(int i=0;i<mat.length;i++) {
			for(int j=i+1;j<mat.length;j++) {
			   swap(mat[i][j],mat[j][i]);
			}
		}
	}

	private static void swap(int i, int j) {
		int temp = i;
		j=i;
		i=temp;
		
	}
	
	public static void printSpiral(int[][] arr) {
		int top=0, bottom = arr.length-1, left = 0,right = arr.length-1;
		
		while(top<=bottom && left <= right) {
			for(int i=left;i<right;i++) {
				System.out.println(arr[top][i]);
			}
			top++;
			for(int i=top;i<=bottom;i++) {
				System.out.println(arr[i][right]);
			}
			right--;
			
			if(left<=right) {
				for(int i=right; i>=left;i--) {
					System.out.println(arr[bottom][i]);
				}
				bottom--;
			}
			if(top<=bottom) {
				for(int i=bottom;i>=top;i--) {
					System.out.println(arr[i][left]);
				}
				left++;
			}
		}
	}
	
	public static boolean searchInSortedMatix(int[][] matrix, int x) {
		int i = 0, j= matrix.length-1;
		
		while(j>=0 && i<matrix.length-1) {
			if(matrix[i][j]==x) {
				return true;
			}
			if(matrix[i][j]>x) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}

}

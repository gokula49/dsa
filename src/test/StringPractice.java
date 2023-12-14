package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utility.Node;

public class StringPractice {
    static final int CHAR = 256;
	public static void main(String[] args) {
		String str1 = "abcdee", str2 = "abe";
		System.out.println(langestDist("abcdc"));
		System.out.println(efficientAnagramSearch("goksahsadi", "saish"));
		System.out.println(subSecuence(str1, str2, str1.length(), str2.length()));
		System.out.println(isAnagram("gokula", "gokuai"));
		System.out.println(leftMostReapeatingCharacterA1("gookgulakannan"));
		
		List<String> list = new ArrayList<>();
		
	}

	public static String reverseWords(String s) {
		String[] arr = s.split(" ");
		System.out.println(arr.length);
		String str = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			if (!arr[i].equals("")) {
				String s1 = arr[i].trim();
				str = str.concat(s1 + " ");
			}
		}
		return str.trim();
	}

	public static int langestDist(String str) {
		int[] arr = new int[CHAR];

		Arrays.fill(arr, -1);

		int maxEnd = 0, res = 0, i = 0;

		for (int j = 0; j < str.length(); j++) {
			i = Math.max(i, arr[str.charAt(j)] + 1);
			maxEnd = j - i + 1;
			res = Math.max(res, maxEnd);
			arr[str.charAt(j)] = j;

		}
		return res;

	}

	public static boolean efficientAnagramSearch(String txt, String pat) {
		int[] ct = new int[256];
		int[] cp = new int[256];

		for (int i = 0; i < pat.length(); i++) {
			cp[pat.charAt(i)]++;
			ct[txt.charAt(i)]++;
		}

		for (int i = pat.length(); i < txt.length(); i++) {
			if (cheackArray(cp, ct) == true) {
				return true;
			}
			ct[txt.charAt(i)]++;
			ct[txt.charAt(i - pat.length())]--;
		}

		return false;

	}

	private static boolean cheackArray(int[] cp, int[] ct) {
		// TODO Auto-generated method stub
		for (int i = 0; i < cp.length; i++) {
			if (cp[i] != ct[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean subSecuence(String s1, String s2, int n, int m) {
		if (m == 0)
			return true;
		if (n == 0)
			return false;

		if (s1.charAt(n - 1) == s1.charAt(m - 1)) {
			return subSecuence(s1, s2, n - 1, m - 1);
		} else {
			return subSecuence(s1, s2, n - 1, m);
		}

	}

	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		int[] arr = new int[CHAR];

		for (int i = 0; i < str1.length(); i++) {
			arr[str1.charAt(i)]++;
			arr[str2.charAt(i)]--;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				return false;
		}
		return true;
	}

	public static int leftMostReapeatingCharacterA1(String str) {
		int[] arr = new int[CHAR];
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i)]++;
		}

		for (int i = 0; i < str.length(); i++) {
			if (arr[str.charAt(i)] > 1)
				return i;
		}
		return -1; //mallikarjun
	}
	
	
	
	

}

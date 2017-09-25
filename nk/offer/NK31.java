/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class NK31 {
	private static int mod = 1000000007;
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {

		int []a = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
		println(solve(a));

	}


	public static long solve(int []a) {
		int n = a.length;
		int []t = new int[n];

		return mergeSortInner(a, 0, n - 1, t);

	}

	public static long mergeSortInner(int []a, int left, int right, int []t) {
		long res = 0;
		if (left >= right)return res;
		int mid = (right + left) / 2;
		res = (res + mergeSortInner(a, left, mid, t)) % mod;
		res = (res + mergeSortInner(a, mid + 1, right, t)) % mod;
		res = (res + merge(a, left, mid, right, t)) % mod;
		return res;
	}

	public static long merge(int []a, int left, int mid, int right, int []t) {
		long res = 0;
		int i = left, j = mid + 1, k = 0;
		while (i <= mid && j <= right) {
			if (a[i] > a[j]) {
				t[k++] = a[i++];
				res += right-j+1;
			} else t[k++] = a[j++];
		}

		while (i <= mid)t[k++] = a[i++];
		while (j <= right)t[k++] = a[j++];
		for (int tk = 0; tk < k; tk++) {
			a[left + tk] = t[tk];
		}
		return res;
	}

	
}
/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;
import java.util.regex.*;

public class NK34 {
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void printlnArray(int [] e) {
		for (int i : e) {
			print(i + " ");
		}
		print("\n");
	}

	public static void main(String []args) {


		String content = "a.a";
		println()

		String pattern = "ab*ac*a";

		boolean isMatch = Pattern.matches(pattern, content);
		System.out.println(isMatch);

		int []a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		multiply(a);

	}

	public static int[] multiply(int[] a) {
		int n = a.length;
		if (n <= 0)return a;
		int []t = new int[n];
		Arrays.fill(t, 1);
		for (int i = 1; i < n; i++) {
			t[i] = t[i - 1] * a[i - 1];
		}

		int tmp = 1;
		for (int i = n - 2; i >= 0; i--) {
			tmp *= a[i + 1];
			t[i] *= tmp;
		}
		return t;
	}
}
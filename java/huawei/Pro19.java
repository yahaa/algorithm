/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;
import java.text.DecimalFormat;

public class Pro19 {
	public static Scanner input = new Scanner(System.in);
	public static DecimalFormat df = new DecimalFormat("#.0");

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {
		// // countit();
		// // while(input.hasNext()){
		// // 	// int a=input.nextInt();
		// // 	// int b=input.nextInt();
		// // 	// println(a*b/GCD(a,b));
		// // 	// double n=input.nextInt();
		// // 	// println(mySqrt(n));
		// // 	// println(df.format(cubeRoot(n)));
		// // 	StringBuffer bf=new StringBuffer(input.nextLine());
		// // 	println(bf.reverse());

		// // }

		// // while (input.hasNext()) {
		// // 	String s = input.nextLine();
		// // 	sortChar(s);
		// // }
		// rabbit();

	}

	public static void rabbit() {
		int mxxx = 33;
		int []month = new int[mxxx];
		month[1] = month[2] = 1;
		for (int i = 3; i < mxxx; i++) {
			month[i] = month[i - 1] + month[i - 2];
		}

		while (input.hasNext()) {
			int n = input.nextInt();
			println(month[n]);
		}
	}

	public static void sortChar(String s) {
		char []chs = s.toCharArray();
		Arrays.sort(chs);
		String res = new String(chs);
		println(res);
	}


	public static void split(String s) {
		String []t = s.split("[^0-9]+");

		int m = 0;
		for (String tt : t) {
			m = max(m, tt.length());
		}

		for (String tt : t) {
			if (tt.length() == m) {
				print(tt);
			}
		}
		println("," + m);
	}

	public static void countit() {
		int ng = 0;
		int nog = 0;
		double ss = 0;
		while (input.hasNext()) {
			int t = input.nextInt();
			if (t < 0)ng++;
			else {
				ss += t;
				nog++;
			}
		}

		println(ng);
		println(df.format(ss / nog));
	}


	public static int LCI(int []a) {
		int n = a.length;
		int []dp = new int[n];
		int []dp2 = new int[n];
		int res = 1;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					dp[i] = max(dp[i], dp[j] + 1);
				}
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			dp2[i] = 1;
			for (int j = n - 1; j > i; j--) {
				if (a[i] > a[j])dp2[i] = max(dp2[i], dp2[j] + 1);
				res = max(res, dp[i] + dp2[i]);
			}
		}
		return res;
	}

	public static int GCD(int a, int b) {
		if (b == 0)return a;
		return GCD(b, a % b);
	}

	public static double cubeRoot(double a) {
		double res = a;
		double px = 0.0000000001;
		while (true) {
			double last = res;
			res = res - res / 3 + a / (3 * res * res);
			if (abs(res - last) <= px)break;
		}
		return res;
	}

	public static double mySqrt(double n) {
		double res = n;
		double px = 0.000000000000000001;
		int t = 0;
		while (true) {
			double last = res;
			res = res - res / 2 + n / (2 * res);
			println(t++);
			if (abs(res - last) <= px)break;

		}
		return res;
	}

	
}
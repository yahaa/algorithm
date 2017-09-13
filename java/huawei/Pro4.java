/**
*	Author: zihua
**/
import java.util.*;
public class Pro4 {
	public static Scanner input = new Scanner(System.in);

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static void solve(String s) {
		int n = s.length();
		int t = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != ' ') {
				print(s.charAt(i));
				t++;
				if (t % 8 == 0) {
					print("\n");
					t = 0;
				}
			}
		}

		for (int i = t; i < 8 && i != 0; i++)print('0');
		print("\n");
	}

	public static void main(String []args) {
		String s1=input.nextLine();
		String s2=input.nextLine();
		solve(s1);
		solve(s2);

		

	}
}
/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class Pro17 {
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {
		while (input.hasNext()) {
			int x = 0, y = 0;
			String s = input.nextLine();
			String []dir = s.split("[;]+");
			for (String t : dir) {
				if (ok(t)) {
					int v = Integer.valueOf(t.substring(1));
					if (t.charAt(0) == 'A' || t.charAt(0) == 'S')v = -v;
					if (t.charAt(0) == 'A' || t.charAt(0) == 'D')x += v;
					else y += v;
					// println(x + "," + y);
				}

			}
			println(x + "," + y);
		}

	}

	public static boolean ok(String s) {
		if (s == null || s.length() <= 0)return false;
		for (int i = 1; i < s.length(); i++) {
			if ((int)s.charAt(i) > 57 || (int)s.charAt(i) < 48)return false;
		}
		if (s.charAt(0) == 'A' || s.charAt(0) == 'D' || s.charAt(0) == 'W' || s.charAt(0) == 'S')return true;
		return false;
	}

}
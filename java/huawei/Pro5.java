/**
*	Author: zihua
**/
import java.util.*;
import java.lang.Math;
public class Pro5 {
	public static Scanner input = new Scanner(System.in);

	public static Map<Character, Integer>map = new TreeMap<Character, Integer>();

	public static void init() {
		for (int i = 0; i < 10; i++) {
			map.put((char)(48 + i), i);
		}
		for (int i = 0; i < 6; i++) {
			map.put((char)(65 + i), i + 10);
		}

	}
	public static <E> void print(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {
		init();
		while (input.hasNext()) {
			String s = input.next();
			s = s.replace("0x", "");
			int n = s.length();
			long res = 0;
			int p = 0;

			for (int i = n - 1; i >= 0; i--) {
				res += map.get(s.charAt(i)) * Math.pow(16, p++);
			}

			print(res);
		}


	}
}
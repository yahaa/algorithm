/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class Pro18 {
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {
		int []res = new int[8];
		while (input.hasNext()) {
			String s = input.nextLine();
			String []ips = s.split("~");


			int ipk = justip(ips[0]);
			res[ipk]++;
			int subk = justsub(ips[1]);
			res[subk]++;
			int pirip = justpri(ips[0]);
			res[pirip]++;
		}
		for (int i = 0; i < 7; i++) {
			print(res[i] + " ");
		}
		print("\n");
	}

	public static int justip(String s) {
		String []t = s.split("[\\.]");
		if (t.length < 4)return 5;
		for (int i = 0; i < 4; i++) {
			int v = Integer.valueOf(t[i]);
			if (v > 255 || v < 0)return 5;
		}

		int v1 = Integer.valueOf(t[0]);
		int v2 = Integer.valueOf(t[1]);
		if (v1 == 10)return 6;
		if (v1 == 172 && (v2 >= 16 && v2 <= 31))return 6;
		if (v1 == 192 && v2 == 168)return 6;


		if (v1 < 127)return 0;
		if (v1 < 192)return 1;
		if (v1 < 224)return 2;
		if (v1 < 240)return 3;
		if (v1 < 256)return 4;
		return 7;
	}

	public static int justsub(String s) {
		String []t = s.split("\\.");
		if (t.length < 4)return 5;
		String bi = "";
		for (int i = 0; i < 4; i++) {
			bi += Integer.toString(Integer.valueOf(t[i]), 2);
		}

		return (bi.split("[0]+").length) <= 1 ? 6 : 7;
	}

	public static int justpri(String s) {
		int tt = justip(s);
		if (tt != 5) {
			String []t = s.split("\\.");
			if (t.length < 4)return 7;
			for (int i = 0; i < 4; i++) {
				int v = Integer.valueOf(t[i]);
				if (v > 255 || v < 0)return 7;
			}


		}
		return 7;

	}
}
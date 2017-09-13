/**
*	Author: zihua
**/
import java.util.*;

public class Pro15 {
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {
		while (input.hasNext()) {
			int money = input.nextInt();
			int n = input.nextInt();
			P []all = new P[n + 1];
			int id = 0;
			while (n-- > 0) {
				int v = input.nextInt();
				int w = input.nextInt();
				int p = input.nextInt();
				if (p == 0) {
					all[id] = new P(v, w, id);
					id++;
				} else {
					all[p - 1].value += v;
					all[p - 1].weith += w;
				}
			}

			Arrays.sort(all, 0, id);
			int res = 0;
			for (int i = 0; i < id; i++) {
				if (all[i].value <= money) {
					res += all[i].total();
					money -= all[i].value;
				}
			}

			println(res);


		}

	}
}

class P implements Comparable<P> {
	public int value;
	public int weith;
	public int no;

	public P(int v, int w, int no) {
		value = v;
		weith = w;
		this.no = no;
	}


	@Override
	public int compareTo(P p) {
		if (this.total() < p.total())return 1;
		else if (this.total() == p.total()) {
			if (value < p.value)return -1;
			if (value == p.value)return 0;
			return 1;

		}
		return -1;
	}

	public int total() {
		return value * weith;
	}
}
/**
*	Author: zihua
**/
import java.util.*;
public class Pro8 {
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {
		Map<Integer, Integer>res = new TreeMap<>();
		while (input.hasNext()) {
			res.clear();
			int n = input.nextInt();
			while (n-- > 0) {
				int k = input.nextInt();
				int v = input.nextInt();
				if (res.get(k) != null) v += res.get(k);
				res.put(k, v);
			}

			for (Map.Entry<Integer, Integer> en : res.entrySet()) {
				print(en.getKey() + " " + en.getValue());
			}
		}

	}
}
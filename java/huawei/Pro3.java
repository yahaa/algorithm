/**
*	Author: zihua
**/
import java.util.*;
import java.util.TreeSet;
public class Pro3 {
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {
		while (input.hasNext()) {
			int n = input.nextInt();
			TreeSet<Integer>res = new TreeSet<>();
			while (n-- > 0) {
				res.add(input.nextInt());
			}
			for (Integer i : res) {
				print(i);
			}
		}
	}
}
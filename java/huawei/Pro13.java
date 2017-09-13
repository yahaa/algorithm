/**
*	Author: zihua
**/
import java.util.*;

public class Pro13 {
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {
		ArrayList<String>res = new ArrayList<>();
		while (input.hasNext()) {
			res.clear();
			int n = input.nextInt();
			while (n-- > 0) {
				res.add(input.next());
			}
			Collections.sort(res);
			for(String s:res){
				println(s);
			}
		}


	}
}
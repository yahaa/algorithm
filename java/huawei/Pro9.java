/**
*	Author: zihua
**/
import java.util.*;
public class Pro9 {
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {
		int []num = new int[10];
		while (input.hasNext()) {
			Arrays.fill(num, 0);
			String s = input.nextLine();
			int n = s.length();
			int c = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (c == 0&&s.charAt(i)!='0') {
					c++;
					num[(char)s.charAt(i)-48]++;
					print(s.charAt(i));
				}
				else if(c!=0){
					if(num[(char)s.charAt(i)-48]==0){
						print(s.charAt(i));
						num[(char)s.charAt(i)-48]++;
					}
				}
			}
			print("\n");
		}

	}
}
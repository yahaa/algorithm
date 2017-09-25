/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class NK67 {
	public static Scanner input = new Scanner(System.in);
	public static int[][]m = {
		{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
		{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
	};

	public static void main(String []args) {

		while (input.hasNext()) {
			int year = input.nextInt();
			int month = input.nextInt();
			int day = input.nextInt();

			int k = what(year);
			int ans = 0;
			for (int i = 0; i < month - 1; i++) {
				ans += m[k][i];
			}
			ans += day;
			System.out.println(ans);
		}


	}

	public static int what(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)return 0;
		return 1;
	}
}
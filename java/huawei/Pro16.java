/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class Pro16 {
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
			int []price = new int[n + 1];
			int []value = new int[n + 1];
			int []no = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				price[i] = input.nextInt();
				value[i] = input.nextInt() * price[i];
				no[i] = input.nextInt();
			}

			int [][]dp = new int[n + 1][money + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= money; j++) {
					if (no[i] == 0) {
						if (price[i] <= j) {
							dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - prive[i]] + value[i])
						}
					} else {
						if(price[i]+price[no[i]]<=j){
							dp[i][j]=max(dp[i-1][j],dp[i-1][j-price[i]-price[no[i]]]+value[i]+value[no[i]]);
						}
					}
				}
			}

			println(dp[n][money]);
		}

	}


}
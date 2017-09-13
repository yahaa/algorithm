/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class NK30 {
	public static Scanner input = new Scanner(System.in);

	public static <E> void print(E e) {
		System.out.print(e);
	}

	public static <E> void println(E e) {
		System.out.println(e);
	}

	public static void main(String []args) {


	}

	public static int firstc(String str) {
		int n = str.length();
		if (n <= 0) return -1;
		Map<Character, Integer> map = new TreeMap<>();
		map.put(str.charAt(0), 0);
		for (int i = 1; i < n; i++) {
			Character t = str.charAt(i);
			if (map.containsKey(t)) {
				map.put(t, -1);
			} else {
				map.put(t, i);
			}
		}

		int res = n;
		for (Map.Entry<Character, Integer> en : map.entrySet()) {
			int v = en.getValue();
			if (v == -1) continue;
			res = Math.min(res, v);
		}
		return res;
	}

	public static int revs(int []array) {
		int n = array.length;
		int []dp = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			dp[i] = 0;
			for (int j = i; j <= n - 1; j++) {
				if (array[i] > array[j])dp[i] = max(dp[i], dp[j] + 1);
			}
		}

		int res=0;
		for(int i=0;i<n-1;i++){
			res=(res+dp[i])%1000000007;
		}
		return res;

	}
}

class OP implements Comparable<OP> {
	public int index;
	public int counts;

	@Override
	public int comparaTo(OP o) {
		if (counts < o.counts)return -1;
		else if (counts == o.counts) {
			if (index < o.index)return -1;
			else if (index == o.index)return 0;
			return 1;
		}
		return 1;
	}
}
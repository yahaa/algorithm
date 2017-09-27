/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class NK39 {
	public static Scanner input = new Scanner(System.in);

	public static int [][]dir = {
		{0, 0, -1, 1},
		{ -1, 1, 0, 0}
	};
	public static int movingCount(int t, int rows, int cols) {
		int [][]map = new int[rows][cols];
		return dfs(map, 0, 0, t);

	}

	public static int dfs(int [][]map, int x, int y, int k) {
		int n = map.length;
		int m = map[0].length;
		if (x < 0 || x >= n || y < 0 || y >= m || map[x][y] == 1)return 0;
		String t = "" + x + "" + y;
		int re = 0;
		for (int i = 0; i < t.length(); i++) {
			re += Integer.valueOf(t.charAt(i) + "");
		}

		if (re > k)return 0;
		map[x][y] = 1;
		int ans = 1;
		for (int i = 0; i < 4; i++) {
			int tx = x + dir[0][i];
			int ty = y + dir[1][i];
			ans += dfs(map, tx, ty, k);
		}
		return ans;
	}

	// public static int bfs(int k, int rows, int cols) {
	// 	int ans = 1;
	// 	int [][]map = new int[rows][cols];
	// 	map[0][0] = 1;
	// 	Queue<Pair> q = new LinkedList<>();
	// 	q.offer(new Pair(0, 0));
	// 	while (!q.isEmpty()) {
	// 		Pair t = q.poll();
	// 		int v = map[t.x][t.y];
	// 		for (int i = 0; i < 4; i++) {
	// 			int tx = t.x + dir[0][i];
	// 			int ty = t.y + dir[1][i];
	// 			if (tx >= 0 && tx < rows && ty >= 0 && ty < cols && ok(tx, ty, k) && map[tx][ty] == 0) {
	// 				q.offer(new Pair(tx, ty));
	// 				map[tx][ty] = max(map[tx][ty], v + 1);
	// 				ans = max(map[tx][ty], ans);
	// 			}
	// 		}
	// 	}
	// 	return ans;
	// }
	// private

	// public static boolean ok(int x, int y, int k) {
	// 	String t = "" + x + "" + y;
	// 	int re = 0;
	// 	for (int i = 0; i < t.length(); i++) {
	// 		re += Integer.valueOf(t.charAt(i) + "");
	// 	}
	// 	if (re > k)return false;
	// 	return true;

	// }

	public static void main(String []args) {
		System.out.println(myPow(2, 10));

	}

	public static long myPow(long a, long n) {
		long res = 1;
		while (n > 0) {
			if ((n & 1 ) > 0) {
				res *= a;
			}
			a *= a;
			n >>= 1;
		}
		return res;
	}
}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
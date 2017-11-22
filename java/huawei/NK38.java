/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class NK38 {
	public static Scanner input = new Scanner(System.in);


	private PriorityQueue<Integer> qmin = new PriorityQueue<>(1000);
	private PriorityQueue<Integer> qmax = new PriorityQueue<>(1000, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return -o1.compareTo(o2);
		}
	});
	private int size = 0;



	public void Insert(Integer num) {
		if (size % 2 == 0) {
			qmin.offer(num);
			int t = qmin.poll();
			qmax.offer(t);
		} else {
			qmax.offer(num);
			int t = qmax.poll();
			qmin.offer(t);
		}
		size++;
	}

	public Double GetMedian() {
		if (size % 2 == 1)return qmax.peek() * 1.0;
		else return (qmax.peek() + qmin.peek()) * 1.0 / 2;

	}

	public static void main(String []args) {
		char []ma = {'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};
		char []str = {'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};
		System.out.println(hasPath(ma, 3, 4, str));
	}


	public static int dir[][] = {
		{0, 0, -1, 1},
		{ -1, 1, 0, 0}
	};
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		int la = rows * cols;
		if (la < str.length || la != matrix.length)return false;
		char [][] map = new char[rows][cols];
		int id = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				map[i][j] = matrix[id++];
			}
		}

		int [][]vis = new int[rows][cols];
		int []len = {0};
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dfs(map, vis, i, j, len, str))return true;
			}
		}

		return false;

	}

	public static boolean dfs(char[][]map, int [][]vis, int x, int y, int []len, char []str) {
		int n = map.length;
		int m = map[0].length;
		if (str.length == len[0])return true;
		if (x < 0 || x >= n || y < 0 || y >= m || vis[x][y] == 1)return false;
		if (str[len[0]] != map[x][y])return false;
		len[0]++;
		// System.out.println(len[0]);
		vis[x][y] = 1;
		boolean res = false;
		for (int i = 0; i < 4; i++) {
			int tx = x + dir[0][i];
			int ty = y + dir[1][i];
			res  = res || dfs(map, vis, tx, ty, len, str);
		}

		len[0]--;
		vis[x][y] = 0;
		return res;

	}

}
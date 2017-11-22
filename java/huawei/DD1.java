/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class DD1 {
	public static Scanner input = new Scanner(System.in);
	public static int [][]dir = {
		{0, 0, -1, 1},
		{ -1, 1, 0, 0}
	};

	public static void main(String []args) {
		while (input.hasNext()) {
			solve();
		}

	}


	public static void solve() {
		int m = input.nextInt();
		int n = input.nextInt();
		int k = input.nextInt();
		int [][]map = new int[m][n];
		int ans = 0;
		List<Integer>res = new ArrayList<>();
		while (k-- > 0) {
			int i = input.nextInt();
			int j = input.nextInt();
			ans += check(map, i, j);
			res.add(ans);
		}

		int kd = res.size();
		for (int i = 0; i < kd - 1; i++) {
			System.out.print(res.get(i) + " ");
		}

		if (kd > 0)
			System.out.println(res.get(kd - 1));


	}

	public static int check(int [][]map, int i, int j) {
		int m = map.length;
		int n = map[0].length;
		if (i < 0 || j < 0 || i >= m || j >= n)return 0;
		if (map[i][j] > 0)return 0;
		
		int res=0;

		int c=0;

		for (int id = 0; id < 4; id++) {
			int tx = i + dir[0][id];
			int ty = j + dir[1][id];
			if (tx >= 0 && tx < m && ty >= 0 && ty < n && map[tx][ty] == 1) {
				c++;
			}
		}

		if(c==0)res=1;
		else if(c==3)res=-1;
		else if(c==4)res=-2;
		else if(c==2){
			res=-1;
		}
		if(ok(map,i,j))map[i][j]=1;
		return res;

	}

	public static boolean ok(int [][]map,int x,int y){
		int m=map.length;
		int n=map[0].length;
		if(x>=0&&x<m&&y>=0&&y<n)return true;
		return false;

	}

	public static void printarr(int []a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
	}
}

class Node{
	public int x;
	public int y;
}
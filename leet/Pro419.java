public class Pro419 {
	private  int []di = { -1, 1, 0, 0};
	private  int []dj = {0, 0, -1, 1};
	private  char [][]bor;
	private  int n, m;

	public  int countBattleships(char[][] board) {
		bor = board;
		n = board.length;
		m = board[0].length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (bor[i][j] == 'X') {
					dfs(i, j);
					ans++;
				}
			}
		}

		return ans;
	}

	public  void dfs(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)return;
		if (bor[x][y] == '.')return;
		bor[x][y] = '.';
		for (int i = 0; i < 4; i++) {
			int tx = x + di[i];
			int ty = y + dj[i];
			dfs(tx, ty);
		}
	}

	public  void main(String[]args) {
		char [][]b = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};

		System.out.println(countBattleships(b));
	}
}
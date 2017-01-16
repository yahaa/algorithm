public class Pro463 {
	public static void main(String[]) {

	}

	public int islandPerimeter(int[][] grid) {
		int n=grid.length;
		int m=grid[0].length;
		int total=0;
		int tl=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(grid[i][j]==1){
					total++;
					if(i-1>=0&&grid[i-1][j]==1)tl++;
					if(j-1>=0&&grid[i][j-1]==1)tl++;
				}
			}
		}

		return total*4-2*tl;
	}
}
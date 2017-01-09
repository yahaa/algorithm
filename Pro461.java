public class Pro461 {
	public static void main(String[]args) {


	}

	public static int hammingDistance(int x, int y) {
		int t = x ^ y;
		return count0(t);
	}

	public static int count0(int x) {
		int res = 0;
		while (a > 0) {
			res++;
			a -= a & -a;
		}
		return res;
	}
}
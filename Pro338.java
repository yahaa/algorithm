public class Pro338 {
	public static void main(String[]args) {

		

	}

	public static int[] countBits(int num) {
		int []res = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			res[i] = count1(i);
		}
		return res;
	}

	public static count1(int n) {
		int res = 0;
		while (n > 0) {
			n -= n & -n;
			res++;
		}

		return res;
	}
}
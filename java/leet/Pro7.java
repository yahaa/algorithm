public class Pro7 {
	public static void main(String[]args) {
		
	}

	public static int reverse(int x) {
		if (x == 0)return x;
		Long tx = Long.valueOf(x);
		if (x < 0)tx = -tx;
		StringBuilder a = new StringBuilder(tx.toString());
		Long t = Long.valueOf(a.reverse().toString());
		if (t > Integer.MAX_VALUE)return 0;
		else {
			Integer xx = Integer.valueOf(x);
			if (x < 0)xx = -xx;
			a = new StringBuilder(xx.toString());
			Integer tt = Integer.valueOf(a.reverse().toString());
			if (x < 0)return -tt;
			else return tt;
		}

	}
}
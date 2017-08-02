import static java.lang.Math.*;
public class Pro5 {
	public static void main(String[]args) {

		String s = longestPalindrome("abba");

	}

	public static String longestPalindrome(String s) {

		StringBuilder ts = new StringBuilder();
		ts.append("#");
		int len = s.length();
		for (int i = 0; i < len; i++) {
			ts.append(s.charAt(i));
			ts.append("#");
		}

		len = ts.length();
		int []p = new int[len];
		int maxRight = 0;
		int mid = 0;

		int ans = 0;
		int j = 0;
		for (int i = 0; i < len; i++) {
			if (i < maxRight)
				p[i] = min(p[2 * mid - i], maxRight - i);
			else
				p[i] = 1;
			while (i - p[i] >= 0 && i + p[i] < len && ts.charAt(i - p[i]) == ts.charAt(i + p[i]))p[i]++;
			if (p[i] + i - 1 < maxRight) {
				maxRight = p[i] + i - 1;
				mid = i;
			}

			if (p[i] - 1 > ans) {
				ans = p[i] - 1;
				j = i;
			}
		}

		return s.substring((j - ans) / 2, (j + ans) / 2);

	}
}
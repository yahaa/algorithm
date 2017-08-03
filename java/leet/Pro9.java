import static java.lang.Math.*;
public class Pro9 {
	public static void main(String[]args) {
		System.out.println(isPalindrome(1234));
		System.out.println(isP(1));

	}

	public static boolean isPalindrome(int x) {
		if (x < 0)return false;
		if (x < 10)return true;

		int t = x;
		int len = 0;
		while (t > 0) {
			t /= 10;
			len++;
		}

		int left = (int)pow(10, len - 1);
		int right = 1;
		while (right <= left) {
			if (x / left % 10 != x / right % 10) {
				return false;
			}
			left /= 10;
			right *= 10;
		}
		return true;
	}

	public static boolean isP(int x){
		if(x<0)return false;
		if(x<10)return true;
		Integer a=Integer.valueOf(x);
		String s=a.toString();
		int len=s.length();
		for(int i=0,j=len-1;i<j;i++,j--){
			if(s.charAt(i)!=s.charAt(j))return false;
		}
		return true;

	}
}
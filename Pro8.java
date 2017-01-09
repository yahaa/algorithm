import static java.lang.Character.*;
public class Pro8 {
	public static void main(String[]args) {
		System.out.println(myAtoi("9223372036854775809"));
	}

	public static int myAtoi(String str) {
		if (str == null)return 0;
		str = str.trim();
		if (str.length() == 0)return 0;
		int index = 0;
		int f = 1;
		if (str.charAt(index) == '+') {
			index++;
		} else if (str.charAt(index) == '-') {
			index++;
			f = -1;
		}

		int ti = index;
		int len = str.length();
		long value = 0;
		int res=0;

		while (index < len && isDigit(str.charAt(index))) {
			int t = str.charAt(index) - '0';
			value = value * 10 + t;
			index++;
			if(value>=-(Long.valueOf(Integer.MIN_VALUE)))break;
			res=res*10+t;
		}

		value*=f;
		res*=f;
		if (value >= Integer.MAX_VALUE)return Integer.MAX_VALUE;
		else if (value <= Integer.MIN_VALUE)return Integer.MIN_VALUE;
		else return res;

	}
}
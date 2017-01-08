public class Pro6 {

	public static void main(String[]args){
		System.out.println(convert("PAYPALISHIRING", 3));
	}
	public static String convert(String s, int numRows) {
		int len = s.length();
		if (s == null || len == 0 || numRows < 0)return "";
		if (numRows == 1)return s;

		StringBuilder sb = new StringBuilder();
		int size = 2 * numRows - 2;
		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < len; j += size) {
				sb.append(s.charAt(j));
				if (i != 0 && i != numRows - 1 && j + size - 2 * i < len) {
					sb.append(s.charAt(j + size - 2 * i));
				}
			}
		}

		return sb.toString();

	}
}
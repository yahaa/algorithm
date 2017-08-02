public class Pro476 {
	public static void main(String[]args) {
		Integer a = Integer.valueOf(5);
		System.out.println(Integer.toBinaryString(a));
		Integer b = Integer.parseInt("111", 2);
		System.out.println(b);
		System.out.println(findComplement(5));
	}

	public static int findComplement(int num) {
		StringBuilder s=new StringBuilder(Integer.toBinaryString(num));
		int n=s.length();
		for(int i=0;i<n;i++){
			if(s.charAt(i)=='1'){
				s.setCharAt(i,'0');
			}
			else if(s.charAt(i)=='0'){
				s.setCharAt(i,'1');
			}
		}
		return Integer.parseInt(s.toString(),2);
	}
}
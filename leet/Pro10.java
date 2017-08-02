
public class Pro10 {
	public static void main(String[]args) {
		System.out.println(isMatch("ab","."));

	}
	public static boolean isMatch(String s, String p) {
		int lens=s.length();
		int lenp=p.length();
		if(!(p.contains(".")||p.contains("*"))&&lenp<lens)return false;

		for(int i=0;i<lens;i++){
			if(s.charAt(i)!=p.charAt(i))
		}
	}

}
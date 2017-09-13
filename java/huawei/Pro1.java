import java.util.*;
public class Pro1{
	public static Scanner input=new Scanner(System.in);
	public static void main(String []args){
		String s=input.nextLine();
		System.out.println(solve2(s));
		
	}

	public static int solve1(String s){
		String []t=s.split("[ ]+");
		return t[t.length-1].length();
	}

	public static int solve2(String s){
		int n=s.length();
		int res=0;
		for(int i=n-1;i>=0;i--){
			if(s.charAt(i)==' ')break;
			res++;
		}
		return res;
	}
}
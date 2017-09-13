import java.util.*;
public class Pro2{
	public static Scanner input=new Scanner(System.in);
	public static void main(String []args){
		String s=input.next();
		s=s.toLowerCase();
		String ch=input.next();
        ch=ch.toLowerCase();
		int n=s.length();
		int ans=0;
		for(int i=0;i<n;i++){
			if(s.charAt(i)==ch.charAt(0))ans++;
		}
		System.out.println(ans);
	}
}

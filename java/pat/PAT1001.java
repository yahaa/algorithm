import java.util.*;
public class PAT1001{
	public static void main(String []args){
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int t=1;
		while(n-->0){
			long a=input.nextLong();
			long b=input.nextLong();
			long c=input.nextLong();
			System.out.println("Case #"+t+++": "+((a-c+b)>0));
		}
	}
  
}

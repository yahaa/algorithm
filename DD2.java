/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;
import java.math.BigDecimal;

public class DD2 {
    public static Scanner input = new Scanner(System.in);

    public static void main(String []args) {
    	while(input.hasNext()){
    		BigDecimal r=input.nextBigDecimal();
    		int n=input.nextInt();
    		BigDecimal ans=r.pow(n);
    		System.out.println(ans);
    	}
    }
}

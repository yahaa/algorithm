/**
*	Author: zihua
**/
import java.util.*;

public class Pro14 {
    public static Scanner input = new Scanner(System.in);

    public static <E> void print(E e) {
        System.out.print(e);
    }

    public static <E> void println(E e) {
        System.out.println(e);
    }

    public static void main(String []args) {

    	while(input.hasNext()){
    		println(bit1(input.nextInt()));
    	}

    }

    public static int bit1(int n){
    	int res=0;
    	while(n>0){
    		n-=n&-n;
    		res++;
    	}
    	return res;
    }
}
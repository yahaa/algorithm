/**
*	Author: zihua
**/
import java.util.*;

public class Pro11 {
    public static Scanner input = new Scanner(System.in);

    public static <E> void print(E e) {
        System.out.print(e);
    }

    public static <E> void println(E e) {
        System.out.println(e);
    }

    public static void main(String []args) {
    	while(input.hasNext()){
    		StringBuffer bf=new StringBuffer(input.nextLine());
    		bf.reverse();
    		println(bf);
    	}

    }
}
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class Pro12{
    public static void main(String []args){
        for(int i=1;i<=3999;i++)
            System.out.println("map.put(\""+intToRoman(i)+"\","+i+");");
    }

    public static String intToRoman(int num) {
       StringBuffer res=new StringBuffer();
       int t3=num/1000;
       for(int i=0;i<t3;i++){
           res.append("M");
       }
       num%=1000;
       int t2=num/100;
       if(t2/9>=1)res.append("CM");
       else if(t2/5>=1){
           res.append("D");
           int temp=t2%5;
           for(int i=0;i<temp;i++)res.append("C");
       }else if(t2/4>=1)res.append("CD");
       else{
           for(int i=0;i<t2;i++)res.append("C");
       }

       num%=100;
       int t1=num/10;

       if(t1/9>=1)res.append("XC");
       else if(t1/5>=1){
           res.append("L");
           int temp=t1%5;
           for(int i=0;i<temp;i++)res.append("X");
       }else if(t1/4>=1)res.append("XL");
       else{
           for(int i=0;i<t1;i++)res.append("X");
       }

       num%=10;
       int t0=num;
       if(t0/9>=1)res.append("IX");
       else if(t0/5>=1){
           res.append("V");
           int temp=t0%5;
           for(int i=0;i<temp;i++)res.append("I");
       }else if(t0/4>=1)res.append("IV");
       else{
           for(int i=0;i<t0;i++)res.append("I");
       }

       return res.toString();

    }
}

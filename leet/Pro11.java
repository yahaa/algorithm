import static java.lang.Math.*;
import java.util.*;
public class Pro11{
    public static void main(String []args){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=input.nextInt();
        }
        System.out.println(maxArea(a));
    }

    public static int maxArea(int[] height) {
        int n=height.length;
        int res=0;
        int i=0,j=n-1;
        while(i<j){
            res=max(res,area(i,j,height[i],height[j]));
            if(height[i]<height[j])i++;
            else j--;
        }
        return res;
    }

    public static int area(int i,int j,int height1,int height2){
        return (j-i)*min(height1,height2);
    }

}

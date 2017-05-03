import java.util.Arrays;
public class NK1{
    public static void main(String[]args){
    }

    public boolean find(int target, int [][] array) {
        int n=array.length;
        if(n==0)return false;
        int m=array[0].length;
        if(m==0)return false;
        int i=n-1,j=0;
        while(i>=0&&j<m){
            if(target<array[i][j])i--;
            else if(target>array[i][j])j++;
            else return true;
        }
        return false;
    }


}

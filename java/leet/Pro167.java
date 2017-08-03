import java.util.Arrays;
public class Pro167{
    public static void main(String []args){

    }

    public static int[] twoSum(int[] numbers, int target) {
        int []res=new int[2];
        int len=numbers.length;
        for(int i=0;i<len;i++){
            int r=target-numbers[i];
            int j=Arrays.binarySearch(numbers,i+1,len,r);
            if(j>=0){
                res[0]=i+1;
                res[1]=j+1;
                break;
            }
        }
        return res;
    }
}

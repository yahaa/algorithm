import static java.lang.Math.*;
public class Pro485 {
	public static void main(String[]args) {
		int []a={1,1,0,1,1,1};
		System.out.println(findMaxConsecutiveOnes(a));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int n = nums.length;
		int i = 0, j = 0;
		int res=0;
		while(i<n){
			j=i;
			while(j<n&&nums[j]!=0)j++;
			res=max(res,j-i);
			i++;
		}
		return res;
	}
}
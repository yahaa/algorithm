import java.util.*;
public class Pro15 {
	public static void main(String[]args) {
		int []s = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(s));
	}

	public static  List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList < List<Integer>>();
		Arrays.sort(nums);
		int n = nums.length;
		int []vi = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j != i) {
					int c = nums[i]+nums[j];
					int t = Arrays.binarySearch(nums, -c);
					if (t >= 0 && t != i && t != j) {
						if (vi[t] == 0&&vi[i]==0&&vi[j]==0) {
							List <Integer>tt = new ArrayList<Integer>();
							tt.add(nums[i]);
							tt.add(nums[j]);
							tt.add(nums[t]);
							res.add(tt);
							vi[t]=1;
							vi[i]=1;
							vi[j]=1;
						}

					}
				}
			}
		}
		return new ArrayList<List<Integer>>(new HashSet<List<Integer>>(res));

	}
}

import java.util.*;
public class Pro448 {
	public static void main(String[]args) {
		int []a = {1, 5, 3, 4, 6};
		System.out.println(findDisappearedNumbers(a));
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer>res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0)return res;
		Arrays.sort(nums);
		int minum = 1;
		int maxnum = nums.length;
		for (int i = minum; i <= maxnum; i++) {
			int t = Arrays.binarySearch(nums, i);
			if (t < 0)res.add(i);
		}
		return res;


	}
}
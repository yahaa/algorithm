/**
*	Author: zihua
**/
import java.util.*;
import static java.lang.Math.*;

public class NK37 {
	public static int index = 0;
	public static TreeNode KthNode(TreeNode root, int k) {
		index = 0;
		return solve(root, k);

	}

	public static TreeNode solve(TreeNode root, int k) {
		if (root == null || k <= 0)return null;
		TreeNode res = solve(root.left, k);
		if (res != null)return res;
		index++;
		if (index == k)return root;
		return solve(root.right, k);

	}
}


class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}

}

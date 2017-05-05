public class NK17{
    public void Mirror(TreeNode root) {
        if(root==null)return;
        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
        
        Mirror(root.left);
        Mirror(root.right);


    }
}

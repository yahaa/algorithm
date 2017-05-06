public class NK26{
    public static void main(String []args){

    }

    public TreeNode convert(TreeNode root){
        if(root==null)return null;
        TreeNode left=convert(root.left);
        TreeNode last=left;
        while(last!=null&&last.right!=null)last=last.right;
        if(left!=null){
            root.left=last;
            last.right=root;
        }
        TreeNode right=convert(root.right);
        if(right!=null){
            root.right=right;
            right.left=root;
        }
        return left!=null?left:root;
    }
}

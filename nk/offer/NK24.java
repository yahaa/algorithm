import java.util.ArrayList;

public class NK24{
    public static void main(String []args){

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        int sum=0;
        ArrayList<Integer>path=new ArrayList<>();
        ArrayList<ArrayList<Integer>>res=new ArrayList<ArrayList<Integer>>();
        solve(root,target,sum,path,res);
        return res;

    }

    public void solve(TreeNode root,int target,int sum,ArrayList<Integer>path,ArrayList<ArrayList<Integer>>res){
        if(root==null)return;
        sum+=root.val;
        path.add(root.val);
        boolean f=(root.left==null)&(root.right==null);
        if(sum==target&&f){
            ArrayList<Integer>p=new ArrayList<>(path);
            res.add(p);
        }
        solve(root.left,target,sum,path,res);
        solve(root.right,target,sum,path,res);
        sum-=root.val;
        path.remove(path.size()-1);
    }
}

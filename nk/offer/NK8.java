public class NK8{
    public int JumpFloorII(int target) {

        
       //int n=target;
       //if(n==0)return 0;
       //if(n==1)return 1;
       //if(n==2)return 2;
       //return JumpFloorII(n-1)+JumpFloorII(n-2)+1
       if(target==0)return 0;
       return (int)Math.pow(2,target-1);
   }
}

public class NK10{
    public int numberOf1(int n) {
       int res=0;
       while(n!=0){
           n -= n & -n;
           res++;
       }
       return res;
   }
}

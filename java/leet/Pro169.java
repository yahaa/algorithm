public class Pro169{
    // private static Scanner input=new Scanner(System.in);

    public static void main(String []args){
        int []a={-2147483648,0,0};
        System.out.println(solve(a));


    }

    public static int  solve(int []a){
        int count=1;
        int res=a[0];
        int n=a.length;
        for(int i =1;i<n;i++){
            if(res==a[i])count++;
            else count--;
            if(count==0){
                res=a[i];
                count++;
            }
        }
        return res;
    }
}

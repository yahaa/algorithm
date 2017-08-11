public class Pro26{
    public static void main(String []args){
        int []a={1,1,1,1,1,2,3,3,3,4,5,6,6};
        System.out.println(solve(a));
        System.out.println(solve1(a));
    }

    public static int solve(int []args){
        int res=args.length;
        int n=res;
        for(int i=0;i<n;i++){
            while(i+1<n&&args[i]==args[i+1]){
                res--;
                i++;
            }
        }

        for(int i=0;i<n;i++){
            if(i==res-1)break;
            int j=i;
            int t=0;
            while(j+1<n&&args[j]==args[j+1]){
                j++;
                t++;
            }
            if(t>0){
                for(int k=i;k<n-1;k++)args[k]=args[k+1];
                i--;
            }
        }
        return res;
    }

    //方法二借鉴网上做法
    public static int solve1(int []a){
        int n=a.length;
        if(n<2)return n;
        int id=1;
        for(int i=1;i<n;i++){
            if(a[i]!=a[i-1])a[id++]=a[i];
        }

        for(int i=0;i<n;i++){
            System.out.println(a[i]+" ");
        }
        return id;
    }
}

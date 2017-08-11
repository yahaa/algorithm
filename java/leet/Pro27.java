public class Pro27{
    public static void main(String[]args){
        int []a={3,2,3,3,3,2,3};
        System.out.println(solve(a,3));

    }

    public static int solve(int []a,int v){
        int n=a.length;
        int id=0;
        for(int i=0;i<n;i++){
            if(a[i]!=v)a[id++]=a[i];
        }
        return id;

    }
}

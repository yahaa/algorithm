public class Pro566{
    // private Scanner input=new Scanner(System.in);
    public static void main(String []args){
        int [][]a={{1,2,3,4,5,6,7,8,9,10}};
        solve(a,2,5);

    }

    public static int [][] solve(int [][]a,int r,int c){
        int n=a.length;
        if (n<1)return a;
        int m=a[0].length;
        if (n*m!=r*c)return a;
        System.out.println(m);
        int [][]res=new int[r][c];
        int id=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int rj=id%c;
                int ri=(id-rj)/c;
                res[ri][rj]=a[i][j];
                id++;
            }
        }
        return res;

    }
}

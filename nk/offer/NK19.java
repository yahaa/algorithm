import static java.lang.Math.*;
public class NK19{
    public static void main(String []args){
        int [][]mm=new int[3][5];
        int t=1;
        int n=mm.length;
        int m=mm[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mm[i][j]=t++;
            }
        }



        int mi=min(n,m);
        int tn=(mi%2==0)?mi/2:mi/2+1;
        for(int i=0;i<tn;i++){
            visit(mm,i,(n--),(m--));
        }

    }

    public static void visit(int [][]mm,int index,int n,int m){
        int i=j=index;
        while(j<m&&i<n){
            System.out.print(xy(i,j));
            j++;
        }
        j--;i++;
        boolean f2=false;
        while(i<n&&j<m){
            System.out.print(xy(i,j));
            i++;
            f2=true;
        }
        if(f2)i--;j--;
        boolean f3=false;
        while(j>=index&&i<n){
            System.out.print(xy(i,j));
            j--;
            f3=true;
        }
        j++;i--;
        while(i>index&&j<m&&f3){
            System.out.print(xy(i,j));
            i--;
        }
    }

    public static String xy(int x,int y){
        return "("+x+","+y+")";
    }
}

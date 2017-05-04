public class NK7{
    public int jump(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        if(n==2)return 2;
        return jump(n-1)+jump(n-2);
    }
}

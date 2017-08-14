public class Pro35{
    public static void main(String []args){
        int []a={1};
        System.out.println(search(a,1));

    }

    public static int search(int []a,int target){
        int left=0;
        int right=a.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(target==a[mid])return mid;
            if(target<a[mid])right=mid-1;
            else left=mid+1;
        }
        // System.out.println(left+" "+right);
        if(target==a[left])return left;
        if(target<a[left])return left;
        return left+1;

    }
}

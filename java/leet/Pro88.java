public class Pro88{
    public static void main(String []args){
        int []a1=new int[11];
        int []a2=new int[4];
        int m=7;
        int n=4;
        for(int i=0;i<m;i++){
            a1[i]=2*i+1;
        }

        for(int i=0;i<n;i++){
            a2[i]=2*(i+1);
        }

        merge(a1,m,a2,n);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int id=0,i=0,j=0;
        while(i<m&&j<n){
            if(nums1[i]<nums2[j]){
                id++;
                i++;
            }
            else{
                for(int t=m;t>=i+1;t--){
                    nums1[t]=nums1[t-1];
                }
                m++;
                nums1[id++]=nums2[j++];
                i++;
            }
        }

        for(int ii=0;ii<id;ii++){
            System.out.print(nums1[ii]+" ");
        }
        System.out.println();
        if(j<n){
            for(;j<n;j++)nums1[id++]=nums2[j];
        }
        for(int ii=0;ii<nums1.length;ii++){
            System.out.print(nums1[ii]+" ");
        }
    }
}

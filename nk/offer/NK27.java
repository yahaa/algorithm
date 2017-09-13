import java.util.ArrayList;
import static java.util.Collections.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
public class NK27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String>ru=new ArrayList<>();
        if(str.length()<=0)return ru;
        Set<String>res=new TreeSet<>();
        
        char []chs=str.toCharArray();
        nextPermutation(chs,0,chs.length,res);
        ru.addAll(res);
        return ru;
       
    }
    
    public  void nextPermutation(char []chs,int k,int n,Set<String> res){
		if(k==n){
			res.add(new String(chs));
			return;
		}else{
			for(int i=k;i<n;i++){
				swap(chs,i,k);
				nextPermutation(chs,k+1,n,res);
				swap(chs,i,k);
			}
		}

	}

	public  void swap(char []chs,int i,int j){
		char t=chs[i];
		chs[i]=chs[j];
		chs[j]=t;
	}
}
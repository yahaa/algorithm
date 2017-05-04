import java.util.ArrayList;
public class NK12{
    public void reOrderArray(int [] array) {
        ArrayList<Integer>odd=new ArrayList<>();
        ArrayList<Integer>even=new ArrayList<>();
        for(int i:array){
            if(i%2==0)even.add(i);
            else odd.add(i);
        }
        odd.addAll(even);
        for(int i=0;i<odd.size();i++){
            array[i]=odd.get(i);
        }
    }
}

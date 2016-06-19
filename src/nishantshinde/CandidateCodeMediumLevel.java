package nishantshinde;
import java.util.ArrayList;
import java.util.List;
public class CandidateCodeMediumLevel 
{ 
    public static int[] uniqueValue(int input1,int[] input2)
    {
        List<Integer> result = new ArrayList<Integer>(input1);
        
        for(int i=input1-1; i>=0; i--) {
        	result.add(input2[i],i+1);
        }
        
        int[] out = new int[input1];
        for(int i=0;i<input1;i++) {
        	out[i] = result.get(i);
        }
        return out;
        
    }
}
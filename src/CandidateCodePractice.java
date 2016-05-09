import java.util.Arrays;
public class CandidateCodePractice 
{ 

	public static final String EQUAL = "Equal";
	public static final String UNEQUAL = "Unequal";
	public static final String INVALID = "Invalid";
	
    public static String collegecomparison(int input1,int[] input2,int[] input3)
    {
        Arrays.sort(input2);
        Arrays.sort(input3);
        if(input2.length!=input1 || input3.length!=input1) {
        	return INVALID;
        }
        for(int i=0;i<input1;i++) {
        	if(input2[i]<0 || input3[i]<0) {
        		return INVALID;
        	}
        	if(input2[i]!=input3[i]) {
        		return UNEQUAL;
        	}
        }
        return EQUAL;
    }
}
import java.util.Arrays;

public class CandidateCodeMediumLevelTest {

	public static void main(String str[]) {

		test1();
		
	}
	
	public static void test1() {
		CandidateCodeMediumLevel cc = new CandidateCodeMediumLevel();
		
		int input1 = 4;
		int[] input2 = new int[]{2,1,1,0} ;
		System.out.println( Arrays.toString(cc.uniqueValue(input1, input2)) + " ?= {4,2,1,3} ");
	}


	
}


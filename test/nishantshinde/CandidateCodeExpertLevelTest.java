package nishantshinde;
import nishantshinde.CandidateCodeExpertLevel;

public class CandidateCodeExpertLevelTest {

	public static void main(String str[]) {

		test1();
		test2();
		
	}
	
	public static void test1() {
		int input1 = 3;
		int input2 = 6;
		int[] input3 = {3,3,4,4,4,2,3,1,3,2,1,4,7,3,1,6,4,1};
		
		System.out.println(CandidateCodeExpertLevel.GetWaterLevel(input1, input2, input3));
	}

	public static void test2() {
		int input1 = 6;
		int input2 = 3;
		int[] input3 = {3,3,7,3,1,3,4,3,1,4,2,6,4,1,4,2,4,1};
		
		System.out.println(CandidateCodeExpertLevel.GetWaterLevel(input1, input2, input3));
	}
	
}



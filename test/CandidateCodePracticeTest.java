
public class CandidateCodePracticeTest {

	public static void main(String str[]) {

		test1();
		test2();
		test3();
		test4();
		
	}
	
	public static void test1() {
		CandidateCodePractice cc = new CandidateCodePractice();
		
		int test1_1 = 7;
		int[] test1_2 = {12,11,5,2,7,5,-11};
		int[] test1_3 = {5,12,5,7,11,2,11};
		
		System.out.println(cc.collegecomparison(test1_1,  test1_2, test1_3) + " ?= Invalid");
	}

	public static void test2() {
		CandidateCodePractice cc = new CandidateCodePractice();
		
		int test1_1 = 7;
		int[] test1_2 = {12,11,5,2,7,5,11};
		int[] test1_3 = {5,12,5,7,11,2,11};
		
		System.out.println(cc.collegecomparison(test1_1,  test1_2, test1_3) + " ?= Equal");
	}

	
	public static void test3() {
		CandidateCodePractice cc = new CandidateCodePractice();

		int test1_1 = 7;
		int[] test1_2 = {12,11,5,2,7,5,11};
		int[] test1_3 = {5,0,5,7,11,2,11} ;
		
		System.out.println(cc.collegecomparison(test1_1,  test1_2, test1_3) + " ?= Unequal");
	}

	public static void test4() {
		CandidateCodePractice cc = new CandidateCodePractice();
		
		int test1_1 = 7;
		int[] test1_2 = {12,11,5,2,7,5,11} ;
		int[] test1_3 = {5,0,5,7,11,2};
		
		System.out.println(cc.collegecomparison(test1_1,  test1_2, test1_3) + " ?= Invalid");
	}

	
}



public class SemiFinalProblem2Test {
    public static void main(String[] args) {
    	
    	int input1 = 12;
    	int input2 = 12;
    	int input3 = 33;
//    	String input4 = "((2,1),(6,6),(4,2),(2,5),(2,6),(2,7),(3,4),(6,1),(6,2),(2,3),(6,3),(6,4),(6,5),(6,7))";
    	String input4 = "((1,9),(4,2),(4,4),(4,6),(4,8),(4,10),(4,12),(5,2),(5,5),(5,8),(5,9),(5,11),(6,1),"
						+"(6,6),(6,10),(6,11),(7,1),(7,4),(7,7),(7,10),(8,8),(8,12),(9,9),(10,6),(10,10),"
						+"(10,12),(11,11),(12,2),(12,4),(12,6),(12,8),(12,10),(12,12))";

    	System.out.println(
    			SemiFinalProblem2.maxTreeDestroyed(input1, input2, input3, input4) 
    	);

    }
}


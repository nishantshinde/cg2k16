import pranayjoshi.SemiFinal2Nish;

public class SemiFinalProblem2Test {
    public static void main(String[] args) {

    	Worker worker = new Worker() {
			@Override
			public void doWork(int input1, int input2, int input3, String input4) {
				System.out.println(
						"SemiFinalProblem2 -> " + SemiFinalProblem2.maxTreeDestroyed(input1, input2, input3, input4)
				);
				System.out.println(
						"SemiFinal2Nish -> " + SemiFinal2Nish.maxTreeDestroyed(input1, input2, input3, input4)
				);
			}
    	};

//    	System.out.println("Test case 1 results (below) ");testCase1(worker); System.out.println();
//    	System.out.println("Test case 2 results (below) "); testCase2(worker); System.out.println();
//    	System.out.println("Test case 3 results (below) "); testCase3(worker); System.out.println();
//    	System.out.println("Test case 4 results (expected 3) "); testCase4(worker); System.out.println();
//    	System.out.println("Test case 5 results (expected 5) "); testCase5(worker); System.out.println();
    	System.out.println("Test case 6 results (expected 5) "); testCase6(worker); System.out.println();
    	System.out.println("Test case 7 results (expected 3) "); testCase7(worker); System.out.println();
    	System.out.println("Test case 8 results (expected 3) "); testCase8(worker); System.out.println();

    	
    }
    
    static void testCase1(Worker worker) {
    	String destroyed_positions = "((2,1),(6,6),(4,2),(2,5),(2,6),(2,7),(3,4),(6,1),(6,2),(2,3),(6,3),(6,4),(6,5),(6,7))";
    	worker.doWork(6, 7, 14, destroyed_positions);
    }
    
    static void testCase2(Worker worker) {
    	String destroyed_positions = "((1,9),(4,2),(4,4),(4,6),(4,8),(4,10),(4,12),(5,2),(5,5),(5,8),(5,9),(5,11),(6,1),"
						+"(6,6),(6,10),(6,11),(7,1),(7,4),(7,7),(7,10),(8,8),(8,12),(9,9),(10,6),(10,10),"
						+"(10,12),(11,11),(12,2),(12,4),(12,6),(12,8),(12,10),(12,12))";
    	worker.doWork(12, 12, 33, destroyed_positions);
    }

    static void testCase3(Worker worker) {
    	String destroyed_positions = "((2,1),(2,12),(2,23))";
    	worker.doWork(2, 23, 3, destroyed_positions);
    }
    
    static void testCase4(Worker worker) {
    	String destroyed_positions = "((3,1),(3,3),(3,5),(5,2),(5,3),(5,4),(5,5))";
    	worker.doWork(5, 5, 7, destroyed_positions);
    }
    
    static void testCase5(Worker worker) {
    	String destroyed_positions = "((1,1),(1,2),(1,3),(1,4),(1,5),(3,1),(3,3),(3,5))";
    	worker.doWork(5, 5, 8, destroyed_positions);
    }

    static void testCase6(Worker worker) {
    	String destroyed_positions = "((1,1),(2,1),(3,1),(3,3),(3,5),(4,1),(5,1))";
    	worker.doWork(5, 5, 7, destroyed_positions);
    }

    static void testCase7(Worker worker) {
    	String destroyed_positions = "((1,5),(2,5),(3,1),(3,3),(3,5),(4,5))";
    	worker.doWork(5, 5, 6, destroyed_positions);
    }

    static void testCase8(Worker worker) {
    	String destroyed_positions = "((2,5),(3,1),(3,3),(3,5),(4,5),(5,5))";
    	worker.doWork(5, 5, 6, destroyed_positions);
    }
    
    
    static interface Worker {
    	void doWork(int rows, int columns, int plants_destroyed, String destroyed_positions);
    }
}


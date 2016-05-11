import pranayjoshi.SemiFinal2Nish;

public class SemiFinalProblem2Test {
    public static void main(String[] args) {

    	Worker worker = new Worker() {
			@Override
			public void doWork(int input1, int input2, int input3, String input4) {
				System.out.println(
						//SemiFinalProblem2.maxTreeDestroyed(input1, input2, input3, input4)
						SemiFinal2Nish.maxTreeDestroyed(input1, input2, input3, input4)
				);
			}
    	};

    	testCase1(worker);
   // 	testCase2(worker);
    //	testCase3(worker);

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
    
    
    static interface Worker {
    	void doWork(int rows, int columns, int plants_destroyed, String destroyed_positions);
    }
}


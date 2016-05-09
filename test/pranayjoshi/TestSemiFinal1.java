package pranayjoshi;

import java.util.Arrays;
import java.util.Random;

public class TestSemiFinal1 {
    public static void main(String[] args) {

//        int[] input1 = {4,2,3,6};
//        int[] input1 = {1,2,3,4,5,6};
//        int[] input1 = {1,1,1,1,1,1,1,1};
        int[] input1 = getRandomInputArray(80000);

        test(input1,1);
        test(input1,2);
        test(input1,3);

    }
    
    private static void test(int[] input1, int testCase) {
    	
    	long startTime = System.currentTimeMillis();
        int[] output2 = null;
        String name = null;
        
        switch(testCase) {
        
        case 1:
        	name = "SemiFinal1Nish";
        	output2 = SemiFinal1Nish.get(input1,input1.length);
        	break;
        case 2:
        	name = "SemiFinal1";
        	output2 = SemiFinal1.get(input1,input1.length);
        	break;
        case 3:
        	name = "SemiFinal1_2";
        	output2 = SemiFinal1_2.get(input1,input1.length);
        	break;
        }
        
        long endTime = System.currentTimeMillis();
        long sum = 0;
        for(int i=0;i<output2.length;i++){
            sum = sum + output2[i];
        }
//        System.out.println("Output: " +Arrays.toString(output2));
        System.out.println("Sum ("+name+") - " +sum);
        System.out.println("Time taken ("+name+") - " +(endTime - startTime));
    }
    
    
    static int[] getRandomInputArray(int length){
        int[] output = new int[length];
        for(int i=0;i<length;i++){
            int nextValue = getRandomNumber(10000);
            output[i] = nextValue == 0 ? 1 : nextValue;
        }
        return output;
    }
     static Random rn = new Random();
    static int getRandomNumber(int maximum){
       
    	return rn.nextInt(maximum);
    }
}

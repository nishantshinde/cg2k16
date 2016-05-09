package pranayjoshi;

import java.util.Arrays;
import java.util.Random;

public class TestSemiFinal1 {
    public static void main(String[] args) {

//        int[] input1 = {4,2,3,6};
//        int[] input1 = {1,2,3,4,5,6};
//        int[] input1 = {1,1,1,1,1,1,1,1};
        int[] input1 = getRandomInputArray(80000);

        long startTime,endTime;
        int sum;

        startTime = System.currentTimeMillis();
        int[] output1 = SemiFinal1.get(input1.clone(),input1.length);
        endTime = System.currentTimeMillis();
        sum = 0;
        for(int i=0;i<output1.length;i++){
            sum = sum + output1[i];
        }
//        System.out.println("Output: " +Arrays.toString(output1));
        System.out.println("Sum " +sum);
        System.out.println(" Time taken SemiFinal1 " +(endTime - startTime));


        startTime = System.currentTimeMillis();
        int[] output2 = SemiFinal1Nish.get(input1,input1.length);
        endTime = System.currentTimeMillis();
        sum = 0;
//        System.out.println(Arrays.toString(output2));
        for(int i=0;i<output2.length;i++){
            sum = sum + output2[i];
        }
//        System.out.println("Output: " +Arrays.toString(output2));
        System.out.println("Sum " +sum);
        System.out.println(" Time taken SemiFinal1Nish " +(endTime - startTime));
        
//int[] input1 = {1,1,1,1,1,1};
//int[] output = getMergedArray(2, input1, 2);
//        print(output);


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

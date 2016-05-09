package pranayjoshi;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author nshinde
 */
public class SemiFinal1_2 {

	/**
     * @param args the command line arguments
     */
    //static List<Integer> op = new ArrayList<>();
    static int[] op ;
    static int k = 0;
    static int currentLength = 0;
    
    static int[] get(int[] input1,int input2){
        op = new int [input2-1];
        Arrays.sort(input1);
        currentLength = input1.length;
//        log(Arrays.toString(Arrays.copyOf(input1, currentLength)));
        int[] output = get1(input1);
        while(currentLength > 1){
            output = get1(output);
        }
        
     return op;
        
    }
    
    static int[] get1(int[] input1){
      int sum    = input1[0] + input1[1];
        op[k++] = sum;
        mergeArray(sum, input1);
        return input1;
    }
    
    static void mergeArray(int sum, int[] array){
        int i=1;
        boolean inserted = false;
        array[0]=0;
        array[1]=sum;
//        log("------------");
//        log(Arrays.toString(Arrays.copyOf(array, currentLength)));
        // Move before sum
        while(i<(currentLength-1)) {
        	if(array[i]>array[i+1]) {
        		array[i-1]=array[i+1];
        		array[i+1]=array[i];;
        	} else {
        		array[i-1]=array[i];
        	}
//        	log(i + " - " + Arrays.toString(Arrays.copyOf(array, currentLength)));
        	i++;
        }
        array[i-1]=array[i];
        currentLength--;
//        log(Arrays.toString(Arrays.copyOf(array, currentLength)));
        return;
    }
    
    public static boolean LOG = true;
    static void log(String message){
    	if(LOG) {
    		System.out.println(message);
    	}
    }
    
  static void print(int[] array){
      for(int i=0;i<array.length;i++){
          System.out.println(array[i]);
      }
  }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] input1 = {4,2,3,6};
       // int[] input1 = {1,2,3,4,5,6};
        //int[] input1 = {1,1,1,1,1,1,1,1};
//        int[] input1 = getRandomInputArray(80000);
    //    print(input1);
        long startTime = System.currentTimeMillis();
        int[] output = get(input1,input1.length);
        long endTime = System.currentTimeMillis();
        int sum = 0;
        for(int i=0;i<output.length;i++){
        //    System.out.println(output[i]);
            sum = sum + output[i];
        }
        
        System.out.println("Sum " +sum);
        System.out.println(" Time taken " +(endTime - startTime));

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
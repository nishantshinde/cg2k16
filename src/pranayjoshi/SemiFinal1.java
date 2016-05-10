/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pranayjoshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author PJoshi
 */
public class SemiFinal1 {

	/**
     * @param args the command line arguments
     */
    //static List<Integer> op = new ArrayList<>();
    static int[] op ;
    static int k = 0;
    static int[] get(int[] input1,int input2){
    	if(input2 == 1){
    		op = new int[0];
    	}
        op = new int [input2-1];
        System.err.println("the size of op "+op.length);
        Arrays.sort(input1);
        List<Integer> integerList = getListFromAnArray(input1);
        while(integerList.size() > 1){
        	process(integerList);;
        }
//        int[] output = get1(input1,input2);
//        while(output.length > 1){
//            output = get1(output,output.length);
//        }
     //   return Arrays.copyOfRange(op, 0, op.length-1);
     return op;
        
    }
    
    private static void process(List<Integer> list){
    	if(list.size() == 1){
    		return ;
    	}
    	int sum = list.get(0) + list.get(1);
		list.remove(1);
		list.remove(0);
	//	System.out.println("k is " +k);
	//	System.out.println("sum " +sum);
		op[k++] = sum;
		mergeList(list,sum);
    }
    
    private static void mergeList(List<Integer> list,int element){
    	int size = list.size();
    	boolean inserted = false;
    	for(int i=0;i<size;i++){
    		if(element <= list.get(i)){
    			list.add(i, element);
    			inserted = true;
    			break;
    		}
    	}
    	if(!inserted){
    		list.add(element);
    	}
    //	print(list);
    }
    
    private static void print(List<Integer> list) {
		System.out.println("Printing list");
		for(Integer i : list){
			System.out.println(i);
		}
		
	}

	static int[] get1(int[] input1 ,int input2){
         if(input2 == 1){
            return new int[] {0};
        }
        
       
        
      int sum    = input1[0] + input1[1];
        op[k++] = sum;
        int[] output = getMergedArray(sum,input1,2);
      //  get1(output,output.length);
        
        return output;
        
       // return output;
    }
    
    private static List<Integer> getListFromAnArray(int[] array){
    	List<Integer> integerList = new ArrayList<>();
    	for(Integer i :array){
    		integerList.add(i);
    	}
    	
    	return integerList;
    }
    
    static int[] getMergedArray(int elementToMerged ,int[] array,int startIndex){
        int[] mergedSortedArry = new int[array.length - startIndex + 1];
        int j=0;
        boolean inserted = false;
        for(int i=startIndex;i<array.length;i++){
            if(elementToMerged <= array[i] && !inserted){
                mergedSortedArry[j++] = elementToMerged;
                mergedSortedArry[j++] =array[i];
                inserted = true;
            }else{
                mergedSortedArry[j++] =array[i];
            }
        }
        if(!inserted){ // element to be inserted in last location
            mergedSortedArry[j] = elementToMerged;
        }
        return mergedSortedArry;
    }
    
    
  static void print(int[] array){
      for(int i=0;i<array.length;i++){
          System.out.println(array[i]);
      }
  }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
      //  int[] input1 = {4,2,3,6};
        int[] input1 = {1,2,3,4,5,6};
       // int[] input1 = {1,1,1,1,1,1,1,1};
     //   int[] input1 = getRandomInputArray(80000);
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pranayjoshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author PJoshi
 */
public class SemiFinal1 {

	/**
     * @param args the command line arguments
     */
    static int[] outputArray ;
    static int k = 0;
    static int[] get(int[] input1,int input2){
    	if(input2 == 1){
    		outputArray = new int[0];
    	}
        outputArray = new int [input2-1];
        Arrays.sort(input1);
        List<Integer> integerList = getListFromAnArray(input1);
        while(integerList.size() > 1){
        	processList(integerList);;
        }
     return outputArray;
        
    }
    
    private static void processList(List<Integer> list){
    	int sum = list.get(0) + list.get(1);
		list.remove(1);
		list.remove(0);
		outputArray[k++] = sum;
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
    }
    
    
    private static List<Integer> getListFromAnArray(int[] array){
    	List<Integer> integerList = new ArrayList<>();
    	for(Integer i :array){
    		integerList.add(i);
    	}
    	
    	return integerList;
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
    

    
}
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
    //static List<Integer> op = new ArrayList<>();
    static int[] op ;
    static int k = 0;
    static int[] get(int[] input1,int input2){
        op = new int [input2];
        get1(input1,input2);
        Arrays.sort(op);
        
        return Arrays.copyOfRange(op, 1, op.length);
        
    }
    
//    static int[] output;
//    
    static int[] get1(int[] input1 ,int input2){
         if(input2 == 1){
            return new int[] {0};
        }
        
        int[] output = new int[input2-1];
        
        Arrays.sort(input1);
        output[0] = input1[0] + input1[1];
        op[k++] = output[0];
        int j=2;
        for(int i=0;i<output.length -1;i++){
            output[i+1] =  input1[j++];
        }
        get1(output,output.length);
        
        return output;
        
       // return output;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //int[] input1 = {4,2,3,6};
        int[] input1 = {1,2,3,4,5,6};
        int[] output = get(input1,6);
        int sum = 0;
        for(int i=0;i<output.length;i++){
            System.out.println(output[i]);
            sum = sum + output[i];
        }
        
        System.out.println("Sum " +sum);
    }
    
}
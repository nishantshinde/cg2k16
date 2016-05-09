/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pranayjoshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author nshinde
 */
public class SemiFinal1Nish {


	static List<Integer> output = new ArrayList<Integer>();

	static int[] get(int[] input1, int input2) {
		Arrays.sort(input1);
		output.clear();

		List<Integer> inputList = new ArrayList<Integer>();
		for (int i : input1) {
			inputList.add(i);
		}
		
		while (inputList.size() > 1) {
			process(inputList);
		}
		
		int[] outputArray = new int[output.size()];
		int index = 0;
		for (Integer i : output) {
			outputArray[index++] = i;
		}
		return outputArray;
	}

	static void process(List<Integer> inputList) {

		int sum = inputList.get(0) + inputList.get(1);
		inputList.remove(1);
		inputList.remove(0);
		output.add(sum);
		
		int insertionPoint = Collections.binarySearch(inputList, sum);
		if(insertionPoint<0) {
			inputList.add(-(insertionPoint+1), sum);
		} else {
			inputList.add(insertionPoint, sum);
		}
		
	}
	
	

}
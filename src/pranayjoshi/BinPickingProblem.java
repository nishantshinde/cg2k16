package pranayjoshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;

public class BinPickingProblem {
	Logger logger = Logger.getLogger(BinPickingProblem.class.getName());
	int getMinimumBinRequired(int[] weights , int binCapacity){
		
		Arrays.sort(weights);
		List<Integer> weightsList = new ArrayList<>();	
		for(int i=weights.length-1 ;i>=0;i--){
			weightsList.add(weights[i]);
		}
		int numberOfBinsRequired = 1;
		int i = 0;
		int remaningBinCapacity = binCapacity;
		int miniumWeightRemaning = Integer.MAX_VALUE;
		while(weightsList.size() >0 ) {
			//logger.debug("The value of i " +i + " and size of list "+weightsList.size());
			int weight = weightsList.get(i);
			if(weight < miniumWeightRemaning) {
				miniumWeightRemaning = weight;
				
			}
			logger.debug("The weight is " +weight + " the remaningBinCapacity " +remaningBinCapacity);
			if(weight <= remaningBinCapacity){
				remaningBinCapacity = remaningBinCapacity - weight;
				weightsList.remove(i);
//				if(miniumWeightRemaning == weight){
//					miniumWeightRemaning = Integer.MAX_VALUE;
//				}
			}
			if(remaningBinCapacity == 0 && (weightsList.size() > 0)) {
				numberOfBinsRequired++;
				remaningBinCapacity = binCapacity;
				i=0;
			}
		//	logger.debug("The  miniumWeightRemaning weight is " +miniumWeightRemaning + " the remaningBinCapacity " +remaningBinCapacity + " and number of weight remaning in the list " +weightsList.size());
			if(i >= weightsList.size()-1){ // we reached to the last weight  
				if(miniumWeightRemaning > remaningBinCapacity && (weightsList.size() > 0)) {
					numberOfBinsRequired++;
					remaningBinCapacity = binCapacity;
				}
				i = 0;
			}else{
				i++;
			}
			
		}
		
		
		return numberOfBinsRequired;
	}
}

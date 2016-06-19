package nishantshinde;

public class CandidateCodeEasyLevel 
{ 

    public static int passCount(int input1,int input2,int input3)
    {
    	int numOfPlayers = input1;
    	int maxReceive = input2;
    	int passSteps = input3;
    	
    	if(numOfPlayers<3 || numOfPlayers>1000) {
    		return -1;
    	}
    	
    	if(maxReceive<3 || maxReceive>1000) {
    		return -1;
    	}

    	int[] receiveCount = new int[numOfPlayers];
    	
    	int current=0;
    	int passed=0;
    	
    	while(true) {
	    	receiveCount[current]=receiveCount[current]+1;
	    	if(receiveCount[current] == maxReceive) {
	    		return passed;
	    	} else {
	    		if(receiveCount[current]%2==0) {
	    			current = current - passSteps; 
	    		} else {
	    			current = current + passSteps;
	    		}
	    		if(current>=numOfPlayers) {
	    			current = current - numOfPlayers;
	    		} else if(current<0) {
	    			current = current + numOfPlayers;
	    		}
	    		passed++;
	    	}
    	}    	

    }
}
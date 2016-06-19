package nishantshinde;

public class CandidateCodeExpertLevel 
{ 
    public static int GetWaterLevel(int input1,int input2,int[] input3)
    {
        final int r = input1;
        final int c = input2;
        final int[] minWaterHeight = input3;
        
        int[] maxWaterHeight = new int[r*c]; 
        int blockHeight, waterHeight;
        
        // Initialize
        for(int r1=0;r1<r;r1++) {
            for(int c1=0;c1<c;c1++) {
            	blockHeight = myGetData(r1, c1, minWaterHeight, r, c);	
            	waterHeight = blockHeight;
            	// Edges
            	if( (r1==0) || (r1==(r-1)) || (c1==0) || (c1==(c-1)) ) {
            		// Do nothing, so that maxWaterHeight will be same as block height so volume of water will be zero
            	} else {
            		waterHeight = Math.max(waterHeight, myGetData(r1-1,c1,minWaterHeight, r, c)); // Top 
            		waterHeight = Math.max(waterHeight, myGetData(r1,c1-1,minWaterHeight, r, c)); // Left
            		waterHeight = Math.max(waterHeight, myGetData(r1,c1+1,minWaterHeight, r, c)); // Right
            		waterHeight = Math.max(waterHeight, myGetData(r1+1,c1,minWaterHeight, r, c)); // Bottom
            	}
            	mySetData(waterHeight, r1, c1, maxWaterHeight, r,c); 
            }
        }
//        System.out.println("MinWaterHeight ->");
//        displayData(minWaterHeight, r, c);
//        System.out.println("MaxWaterHeight ->");
//        displayData(maxWaterHeight, r, c);
        
        // Let the water flow
        boolean change = true;
        int currentWaterHeight;
        while(change) {
        	change = false;
            for(int r1=1;r1<(r-1);r1++) {
                for(int c1=1;c1<(c-1);c1++) {
                	currentWaterHeight = myGetData(r1, c1, maxWaterHeight, r, c);
                	waterHeight = currentWaterHeight;
            		waterHeight = Math.min(waterHeight, myGetData(r1-1,c1,maxWaterHeight, r, c)); // Top 
            		waterHeight = Math.min(waterHeight, myGetData(r1,c1-1,maxWaterHeight, r, c)); // Left
            		waterHeight = Math.min(waterHeight, myGetData(r1,c1+1,maxWaterHeight, r, c)); // Right
            		waterHeight = Math.min(waterHeight, myGetData(r1+1,c1,maxWaterHeight, r, c)); // Bottom
            		waterHeight = Math.max(waterHeight, myGetData(r1,c1,minWaterHeight, r, c)); // Cannot go below block height
            		if(waterHeight<currentWaterHeight) {
            			change = true;
            			mySetData(waterHeight,r1,c1,maxWaterHeight,r,c);
            		}
                }
            }
            
//            System.out.println("\n Iteration ->");
//            displayData(maxWaterHeight, r, c);
        }
        
        // Calculate volume
        int volume = 0;
        for(int r1=1;r1<(r-1);r1++) {
            for(int c1=1;c1<(c-1);c1++) {
            	volume = volume + myGetData(r1,c1,maxWaterHeight, r,c) - myGetData(r1,c1,minWaterHeight, r,c);
            }
        }
        
//        System.out.println("\n\n INPUT ->");
//        displayData(minWaterHeight, r, c);
//        
//        System.out.println("\n OUTPUT ->");
//        displayData(maxWaterHeight, r, c);
        
        return volume;
        
    }
    
    static int myGetData(int r1, int c1, int[] block, int r, int c) {
    	return block[r1*c + c1];
    }
    
    static void mySetData(int data, int r1, int c1, int[] block, int r, int c) {
    	block[r1*c + c1] = data;
    }
    
    static void myDisplayData(int[] block, int r, int c) {
    	
        for(int r1=0;r1<r;r1++) {
        	System.out.print("[");
            for(int c1=0;c1<c;c1++) {
            	System.out.print( myGetData(r1,c1,block, r,c)+",");
            }
            System.out.println("],");
        }
    }
}
package pranayjoshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class SemiFinal2 {
	
	private static List<Point> points = new ArrayList<>();
	private static Set<Path> paths = new HashSet<>();
	public static int maxTreeDestroyed(int input1, int input2, int input3, String input4) {
		
		if (input1 < 1 || input1 > 100 || input2 < 1 || input2 > 100 || input3 < 3 || input3 > (input1 * input2)) {
			return -1;
		}
		
		int index = 1;
		String s1, s2;
		int x, y;
		try {
			for (int i = 0; i < input3; i++) {
				index = input4.indexOf('(', index);
				s1 = input4.substring(index + 1, index = input4.indexOf(',', index));
				s2 = input4.substring(index + 1, index = input4.indexOf(')', index));
				x = Integer.parseInt(s1) - 1;
				y = Integer.parseInt(s2) - 1;
				if (x < 0 || x >= input1 || y < 0 || y >= input2) {
					return -1;
				}
				Point p = new Point(x, y);
				points.add(p);
			}
		} catch (Exception e) {
			return -1;
		}
		
		loadPath();
		addPointsToPath();
		int max = -1;
		for(Path path :paths){
		    int treesDistroyedInAPath = path.getMonkeyPathLength(input1-1,input2-1);
		    if(treesDistroyedInAPath > -1)
		 //   System.out.println("The distroyed trees in the path " +path +" is " +treesDistroyedInAPath);
		    if(treesDistroyedInAPath > max){
		    	
		        max = treesDistroyedInAPath;
		        
		    }
		}

		
		return max;
	}
	
	private static void loadPath(){
	    for(Point p : points)
	    for(Point point :points){
	        if(!p.equals(point)){
	            Path path = new Path(p,point);
	            paths.add(path);
	        }
	    }
	}
	
	private static void addPointsToPath(){
	    for(Path path :paths){
	        for(Point point :points){
	            if(path.addPointIfItsOnThePath(point)){
	            }
	        }
	    }
	}

	
	
	private static class Point implements Comparable<Point>{
		private final int x,y;
		public Point(int x,int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		@Override
		public int compareTo(Point o) {
			if(this.x == o.x && this.y == o.y) {
				return 0;
			}
			if(this.x == o.x) {
				return this.y - o.y;
			}
			
			return this.x - o.x;
		}
		
		@Override
		public String toString() {
			return("("+(x+1)+","+(y+1)+")");
		}
		
	}
	
	private static class Path {
		private final Point startPoint;
		private final Point endPoint;
		private List<Point> distroyedTrees;
		private List<Point> equDistanceDistroyedTrees;
		public Path(Point startPoint , Point endPoint){
			this.startPoint = startPoint;
			this.endPoint = endPoint;
			distroyedTrees = new ArrayList<>();
			equDistanceDistroyedTrees = new ArrayList<>();
		}
		
		public boolean addPointIfItsOnThePath(Point point) {
			if(point.equals(startPoint) || point.equals(endPoint)){
				distroyedTrees.add(point);
				return true;
			}
			
			
			int dxc = point.x - startPoint.x;
			int dyc = point.y - startPoint.y;

			int dxl = endPoint.x - startPoint.x;
			int dyl = endPoint.y - startPoint.y;

			int cross = dxc * dyl - dyc * dxl;
			
			if(cross == 0) {
				boolean inBetween = false;
				if (Math.abs(dxl) >= Math.abs(dyl)){
					inBetween = dxl > 0 ? 
							  startPoint.x <= point.x && point.x <= endPoint.x :
								  startPoint.x <= point.x && point.x <= endPoint.x;
				}
					 
					else {
						
						inBetween= dyl > 0 ? 
								  startPoint.y <= point.y && point.y <= endPoint.y :
									  startPoint.y <= point.y && point.y <= endPoint.y;
					}
					
				if(inBetween){
					distroyedTrees.add(point);
					return true;
				}
				
			}
			return false;
		}
		
		
		
		public  int getMonkeyPathLength(int maxX, int maxY){
			if(distroyedTrees.size() < 3) {
				return -1;
			}
			Collections.sort(distroyedTrees);
			double pathLength = Math.sqrt(sqrOfdistanceBetweenPoints(startPoint,endPoint));
			int minJump = (int) (pathLength / distroyedTrees.size());
			int maxJump = (int) (pathLength) / 2;
			int presentJump = minJump < 1 ? 1: minJump;
			int i = 0;
			int skipLevel = 1;
			equDistanceDistroyedTrees.clear();
			boolean pathFound = true;
			Point p1, p2, p3;
			while(presentJump <= maxJump){
					p1 = distroyedTrees.get(i);
					p2 = distroyedTrees.get(i+skipLevel);
					equDistanceDistroyedTrees.add(p1);
					equDistanceDistroyedTrees.add(p2);
					int distance = sqrOfdistanceBetweenPoints(p1, p2);
					while(i+1+skipLevel < distroyedTrees.size() ){
						i++;
						p3 = distroyedTrees.get(i+skipLevel);
						int newDistance = sqrOfdistanceBetweenPoints(p2, p3);
						if(distance == newDistance){
							p2 = p3;
							equDistanceDistroyedTrees.add(p2);
						}else if((newDistance < distance) ) { //&&  (i+1+skipLevel < distroyedTrees.size())
							int k=i+1;
							while((newDistance <= distance) && (k+skipLevel < distroyedTrees.size()) ){
								p3 = distroyedTrees.get(k+skipLevel);
								newDistance = sqrOfdistanceBetweenPoints(p2, p3);
								if(distance == newDistance){
									p2 = p3;
									equDistanceDistroyedTrees.add(p2);
									break; 
								}else{
								}
								k++;
							}

						}else{
							skipLevel++;
							i = 0;
							pathFound = false;
							equDistanceDistroyedTrees.clear();
							break;
						}
					}
					presentJump++;
					if(pathFound){
						
						
						Point point1 = equDistanceDistroyedTrees.get(0);
						Point point2 = equDistanceDistroyedTrees.get(1);
						int dx = Math.abs(point1.x - point2.x);
						int dy = Math.abs(point1.y - point2.y);
						
						if(p2.equals(startPoint)){
							p2 = point1; 
						}
						
						
						if( ( ((startPoint.x-dx)<0) || ((startPoint.y-dy)<0) ) // Before start point
								&&( ((p2.x+dx)>maxX) || ((p2.y+dy)>maxY) ) // After end point
						  ){
							
						}else{
							equDistanceDistroyedTrees.clear();
						}
						
						break;
					}else{
						equDistanceDistroyedTrees.clear();
					}
			}
	
			return equDistanceDistroyedTrees.size() == 0 ? -1 :equDistanceDistroyedTrees.size();
		}
		

		private int sqrOfdistanceBetweenPoints(Point startPoint,Point endPoint){
			int xdiff = startPoint.x - endPoint.x;
			int ydiff = startPoint.y-endPoint.y;
			return  xdiff*xdiff + ydiff*ydiff;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (startPoint.x + startPoint.y + endPoint.x + endPoint.y);
			//result = prime * result + ((startPoint == null) ? 0 : startPoint.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Path other = (Path) obj;
			
			
			if((startPoint.equals(other.startPoint) && this.endPoint.equals(other.endPoint)) || (this.startPoint.equals(other.endPoint) && this.endPoint.equals(other.startPoint)) ){
				return true;
			}
			return false;
		}

		
		@Override
		public String toString() {
			return("("+startPoint+","+endPoint+");");
		}	
	}

	
	
	
	

}

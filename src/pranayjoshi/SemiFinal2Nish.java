package pranayjoshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SemiFinal2Nish {
	
	
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
	//	System.out.println("Total Points " +points.size());
		loadPath();
	//	System.out.println("Total Path " +paths.size());
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
	            path.addPointIfItsOnThePath(point);
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
		public Path(Point startPoint , Point endPoint){
			this.startPoint = startPoint;
			this.endPoint = endPoint;
			distroyedTrees = new ArrayList<>();
			new ArrayList<>();
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
				distroyedTrees.add(point);
				return true;
			}
			return false;
		}
		
		public  int getMonkeyPathLength(int maxX, int maxY){
			
			if(distroyedTrees.size() < 3) {
				return -1;
			}
			Collections.sort(distroyedTrees);

			int currentJumpIndex = 0;
nextjump:	while(currentJumpIndex<(distroyedTrees.size()-2)) {
				currentJumpIndex++;
				// Initialize
				int currentIndex = 0, monkeyPathLength = 2;
				int nextIndex = currentIndex + currentJumpIndex;
				Point currentPoint = distroyedTrees.get(currentIndex);
				Point nextPoint = distroyedTrees.get(nextIndex);
				
				int dx = nextPoint.x - currentPoint.x;
				int dy = nextPoint.y - currentPoint.y;
				
				// Iterate till end
				while((currentIndex + currentJumpIndex)<(distroyedTrees.size()-1)) {
					currentIndex++; monkeyPathLength++;
					nextIndex = currentIndex + currentJumpIndex;
					currentPoint = distroyedTrees.get(currentIndex);
					nextPoint = distroyedTrees.get(nextIndex);
					// Equidistant check fails, try next jump
					if(!((nextPoint.x - currentPoint.x)==dx && (nextPoint.y - currentPoint.y)==dy)) {
						continue nextjump;
					}
				}
				// Reached end
				if((currentIndex + currentJumpIndex)==distroyedTrees.size()-1) {
					if( ( ((startPoint.x-dx)<0) || ((startPoint.y-dy)<0) ) // Before start point
							&&( ((((distroyedTrees.get(currentIndex + currentJumpIndex))).x+dx)>maxX) 
									|| (((distroyedTrees.get(currentIndex + currentJumpIndex)).y+dy)>maxY) ) // After end point
					  ) {
						return monkeyPathLength;
					}
				}	
			}
			
			return -1;
			
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
			
//			if (endPoint == null) {
//				if (other.endPoint != null)
//					return false;
//			} else if (!endPoint.equals(other.endPoint))
//				return false;
//			if (startPoint == null) {
//				if (other.startPoint != null)
//					return false;
//			} else if (!startPoint.equals(other.startPoint))
//				return false;
			
//			if((startPoint.equals(other.startPoint) || this.startPoint.equals(other.endPoint)) && (this.endPoint.equals(other.endPoint) || this.endPoint.equals(other.startPoint)) ){
//				return true;
//			}
			
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
	
	
	
	public static void main(String[] args) {
		
//		Point p1 = new Point(2,3);
//		Point p2 = new Point(7,8);
//		Point p3 = new Point(3,4);
//
//
//		Path path1 = new Path(p1,p2);
//		Path path2 = new Path(p2,p1);
//		Path path3 = new Path(p2,p3);
//		
//		
//		System.out.println("Are the path equal " +path1.equals(path2));
//		System.out.println("Are the path equal " +path2.equals(path1));
//		System.out.println("Are the path equal " +path2.equals(path3));
//		System.out.println("Path 1 hash code " +path1.hashCode());
//		System.out.println("Path 2 hash code " +path2.hashCode());
//		System.out.println("Path 3 hash code " +path3.hashCode());
//
//		// Monkey Path
//		p1 = new Point(1,1);
//		p2 = new Point(3,3);
//		p3 = new Point(5,5);
//
//		Path path4 = new Path(p1,p3);
//		path4.addPointIfItsOnThePath(p1);
//		path4.addPointIfItsOnThePath(p2);
//		path4.addPointIfItsOnThePath(p3);
//		System.out.println("Path 4 isMonkeyPath() " +path4.getMonkeyPathLength(5,5));
//		System.out.println("Path 4 isMonkeyPath() " +path4.getMonkeyPathLength(7,7));
		
		System.out.println(maxTreeDestroyed(6,7,14,""));

	}

}

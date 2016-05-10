package pranayjoshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SemiFinal2Nish {
	
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
			return("("+x+","+y+")");
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
				distroyedTrees.add(point);
				return true;
			}
			return false;
		}
		
		public boolean isMonkeyPath(){
			if(distroyedTrees.size() < 3) {
				return false;
			}
			Collections.sort(distroyedTrees);
			/*
			double pathLength = Math.sqrt(sqrOfdistanceBetweenPoints(startPoint,endPoint));
			int minJump = (int) (pathLength / distroyedTrees.size());
			int maxJump = (int) (pathLength) / 2;
			int presentJump = minJump < 1 ? 1: minJump;
			while(presentJump < maxJump){
				break;
			}
			*/
// NISHANT - START HERE
			int currentJumpIndex = 0;
nextjump:	while(currentJumpIndex<(distroyedTrees.size()-2)) {
				currentJumpIndex++;
				// Initialize
				int currentIndex = 0;
				int nextIndex = currentIndex + currentJumpIndex;
				Point currentPoint = distroyedTrees.get(currentIndex);
				Point nextPoint = distroyedTrees.get(nextIndex);
				
				int dx = nextPoint.x - currentPoint.x;
				int dy = nextPoint.y - currentPoint.y;
				
				// Iterate till end
				while((currentIndex + currentJumpIndex)<(distroyedTrees.size()-1)) {
					currentIndex++;
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
					return true;
				}
			}
			
			return false;
// NISHANT - END HERE
			
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
			return("("+startPoint+","+endPoint+");destroyed="+distroyedTrees);
		}
	}

	
	
	
	
	public static void main(String[] args) {
		
		Point p1 = new Point(2,3);
		Point p2 = new Point(7,8);
		Point p3 = new Point(3,4);


		Path path1 = new Path(p1,p2);
		Path path2 = new Path(p2,p1);
		Path path3 = new Path(p2,p3);
		
		
		System.out.println("Are the path equal " +path1.equals(path2));
		System.out.println("Are the path equal " +path2.equals(path1));
		System.out.println("Are the path equal " +path2.equals(path3));
		System.out.println("Path 1 hash code " +path1.hashCode());
		System.out.println("Path 2 hash code " +path2.hashCode());
		System.out.println("Path 3 hash code " +path3.hashCode());

		// Monkey Path
		p1 = new Point(1,1);
		p2 = new Point(3,3);
		p3 = new Point(5,5);

		Path path4 = new Path(p1,p3);
		path4.addPointIfItsOnThePath(p1);
		path4.addPointIfItsOnThePath(p2);
		path4.addPointIfItsOnThePath(p3);
		System.out.println("Path 4 isMonkeyPath() " +path4.isMonkeyPath());

	}

}

package pranayjoshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SemiFinal2 {
	
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
			while(true){
				
				
				break;
			}
			return false;
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

		
		
		
		
		
		
	}

	
	
	
	
	public static void main(String[] args) {
		
		Point p1 = new Point(2,3);
		Point p2 = new Point(7,8);
		Point p3 = new Point(3,4);
		
		Path path1 = new Path(p1, p2);
		Path path2 = new Path(p2,p1);
		Path path3 = new Path(p2,p3);
		
		System.out.println("Are the path equal " +path1.equals(path2));
		System.out.println("Are the path equal " +path2.equals(path1));
		System.out.println("Are the path equal " +path2.equals(path3));
		System.out.println("Path 1 hash code " +path1.hashCode());
		System.out.println("Path 2 hash code " +path2.hashCode());
		System.out.println("Path 3 hash code " +path3.hashCode());

	}

}

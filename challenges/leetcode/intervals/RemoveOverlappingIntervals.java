package leetcode.intervals;

import java.util.ArrayList;
import java.util.List;



public class RemoveOverlappingIntervals {
	
   private static class Intervals {
		
		private int start;
		private int end;
		
		public Intervals(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		@Override
		public String toString() {
			return "Intervals [start=" + start + ", end=" + end + "]";
		}
		
		
	}

	/*
	 * Input: intervals = [[1,2],[2,4],[1,4]]
	
	   Output: 1
	   
	   Input: intervals = [[1,2],[2,4]]
	
	   Output: 0
	 */
	
	public static int numOfOverlappingInterval(List<Intervals> intervals) {
		if(intervals == null || intervals.isEmpty())
			return -1;
		
		int prevEnd = intervals.get(0).getEnd();
		int numOfRem = 0;
		
		for(int i=1; i<intervals.size(); i++) {
			Intervals iv = intervals.get(i);
			
			if(prevEnd<=iv.getStart()) {
				prevEnd = iv.getEnd();
			}else {
				numOfRem++;
			}
			
		}
		return numOfRem;
	}
	
	public static void main(String[] args) {
		
	}

}

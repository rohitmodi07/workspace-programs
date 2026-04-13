package leetcode.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;




public class InsertIntervals {
	
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
	 * Input: intervals = [[1,3],[4,6]], newInterval = [2,5]
	
	   Output: [[1,6]]
	   
	   Input: intervals = [[1,2],[3,5],[9,10]], newInterval = [6,7]
	
	   Output: [[1,2],[3,5],[6,7],[9,10]]
	 */
	
	public static List<Intervals> insertInterval(List<Intervals> intervals, Intervals itv){
		if(intervals == null || intervals.isEmpty() || itv == null)
			return new ArrayList<>();
		
		intervals.sort((a,b) -> a.getStart()-b.getStart());
		
		List<Intervals> itvlist = new ArrayList<>();
		
		for(int i=0; i<intervals.size(); i++) {
			
			Intervals iv = intervals.get(i);
			
			if(itv == null || iv.getEnd()<itv.getStart()) {
				itvlist.add(iv);
			}else if(iv.getStart()>itv.getEnd()) {
				itvlist.add(itv);
				itvlist.add(iv);
				
				itv = null;
			}else {
				itv.setStart(Math.min(iv.getStart(), itv.getStart()));
				itv.setEnd(Math.max(iv.getEnd(), itv.getEnd()));
			}
			
		}
		
		if(itv != null) {
			itvlist.add(itv);
		}
		
		return itvlist;
	}
	
    public static List<Intervals> mergeIntervals(List<Intervals> intervals){
		
		if(intervals == null || intervals.isEmpty())
			return new ArrayList<>();
		
		Collections.sort(intervals, Comparator.comparing(Intervals::getStart));
		
		List<Intervals> ilist = new ArrayList<>();
		
		Intervals iv = intervals.get(0);
		
		for(int i=1; i<intervals.size(); i++) {
			Intervals iv1 = intervals.get(i);
			
			if(iv.getEnd()>=iv1.getStart()) {
				int start = Math.min(iv.getStart(), iv1.getStart());
				int end = Math.max(iv.getEnd(), iv1.getEnd());
				
				iv.setStart(start);
				iv.setEnd(end);
			}else {
				ilist.add(iv);
				iv = iv1;
			}
			
		}
		ilist.add(iv);
		
		return ilist;
		
	}
	
	public static void main(String[] args) {
		
	}

}

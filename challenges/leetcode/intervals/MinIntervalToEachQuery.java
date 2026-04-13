package leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class MinIntervalToEachQuery {
	
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
	
	//Input: intervals = [[1,3],[2,3],[3,7],[6,6]], queries = [2,3,1,7,6,8]

    // Output: [2,2,3,5,1,-1]
	
	
	public static List<Integer> minIntervals(List<Intervals> intervals, int[] queries){
		if(intervals == null || intervals.isEmpty() || queries == null || queries.length<1)
			return new ArrayList<>();
		
		Collections.sort(intervals, Comparator.comparing(Intervals::getStart));
		
		List<Integer> ilist = new ArrayList<>();
		
		for(int i : queries) {
			
			int minV = Integer.MAX_VALUE;
			
			for(Intervals iv : intervals) {
				if(i>=iv.getStart() && i<=iv.getEnd() ) {
					
					int diff = iv.getEnd()-iv.getStart()+1;
					minV = Math.min(minV, diff);
				}
			}
			
			minV = minV == Integer.MAX_VALUE ? -1 : minV;
			
			ilist.add(minV);
			
		}
		
		return ilist;
	}
	
	public static List<Integer> minIntervalToIncludeQueries(List<Intervals> intervals, int[] queries){
		if(intervals == null || intervals.isEmpty() || queries == null || queries.length<1)
			return new ArrayList<>();
		
		Collections.sort(intervals, Comparator.comparing(Intervals::getStart));
		
		int maxV = Arrays.stream(queries).max().getAsInt();
		
		List<Integer> lst = new ArrayList<>();
		
		for(int i=0; i<queries.length; i++) {
			
			int maxLen = Integer.MAX_VALUE;
			
			for(Intervals iv : intervals) {
				
				if(iv.getStart() == queries[i]) {
					int len = iv.getEnd()-iv.getStart()+1;
					maxLen = Math.min(maxLen, len);
				}else if(iv.getStart() < queries[i] && iv.getEnd() == queries[i]) {
					int len = iv.getEnd()-iv.getStart()+1;
					maxLen = Math.min(maxLen, len);
				}
				
			}
			maxLen = maxLen<maxV ? maxLen : -1;
			
			lst.add(maxLen);
		}
		return lst;
	}
	
    public static List<Integer> minInterval(List<Intervals> intervals, int[] queries){
		
		if(intervals == null || intervals.isEmpty() || queries == null || queries.length<1)
			return new ArrayList<>();
		
		List<Integer> ivlist = new ArrayList<>();
		
		for(int i : queries) {
			
			List<Integer> tempList = new ArrayList<>();
			boolean doesMatch = false;
			
			for(Intervals iv : intervals) {  // [[1,3],[2,3],[3,7],[6,6]], queries = [2,3,1,7,6,8]
				
				if(i>=iv.getStart() && i<=iv.getEnd()) {
					tempList.add(iv.getEnd()-iv.getStart());
					doesMatch = true;
				}
				
			}
			
			if(doesMatch) {
				int min = tempList.stream().mapToInt(val -> val).min().getAsInt();
				ivlist.add(min+1);
			}else {
				ivlist.add(-1);
			}
			
			
			
		}
		return ivlist;
		
	}
	

	public static void main(String[] args) {
       
    	int[] nums = {2,5,4,1,3,8,7,9,6};
    	
    	List<Intervals> intlist = Arrays.asList(new Intervals(1, 3), new Intervals(2, 3), new Intervals(3, 7),
    			new Intervals(6, 6));
    	int[] queries = {2,3,1,7,6,8};
    	
    	System.out.println(" min length containing the given number :::: "+minIntervalToIncludeQueries(intlist, queries));
    	
    }

}

package leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import stages.TestProgram;


public class IntervalsPgm {
	
	private static class Intervals{
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
	
	// [[1,3],[4,6]], newInterval = [2,5]
	
	private static List<Intervals> insertIntervals(List<Intervals> intervals, Intervals newInt){
		
		if(intervals == null || intervals.isEmpty())
			return new ArrayList<>();
		
		Collections.sort(intervals, (a,b) -> a.start);
		List<Intervals> lint = new ArrayList<>();
		
		for(Intervals intval : intervals) {
			
			if(newInt == null || intval.getEnd()<newInt.getStart()) {
				
				lint.add(intval);
				
			}else if(intval.getStart()>newInt.getEnd()) {
				lint.add(newInt);
				lint.add(intval);
				
				newInt = null;
			}else {
				newInt.setStart(Math.min(intval.getStart(), newInt.getStart()));
				newInt.setEnd(Math.max(intval.getEnd(), newInt.getEnd()));
			}
			
		}
		if(newInt != null) {
			lint.add(newInt);
		}
		return lint;
		
	}
	
	//merge intervals
	
    private static Set<Intervals> mergeIntervals(List<Intervals> intervals){
		
		if(intervals == null || intervals.isEmpty())
			return new HashSet<>();
		
		Collections.sort(intervals, (a,b) -> a.start); // 1,3  1,5  6,7  another 2,4 1,5
		Set<Intervals> lint = new HashSet<>();
		
		for(int i=0; i<intervals.size()-1; i++) {  // 1,2  2,3
			Intervals a = intervals.get(i);
			Intervals b = intervals.get(i+1);
			
			if(a.getEnd()<b.getStart()) {
				
				lint.add(a);
				lint.add(b);
				
			}else if(a.getEnd()<=b.getStart() && a.getEnd()<b.getEnd()) {
				lint.add(new Intervals(a.getStart(), b.getEnd()));
			}
			
		}
		
		return lint;
		
	}
    
    // can attend all the meetings
    
    public static boolean canAttendMeetings(List<Intervals> intervals) { // 0,10  15,20, 22,25
    	
    	if(intervals == null || intervals.isEmpty())
    		return false;
    	
    	Collections.sort(intervals, Comparator.comparing(Intervals::getStart));
    	
    	for(int i=0; i<intervals.size()-1; i++) {
    		Intervals a = intervals.get(i);
    		Intervals b = intervals.get(i+1);
    		
    		if(a.getEnd()>b.getStart()) {
    			return false;
    		}
    	}
    	return true;
    }
    
    // meeting 2 , number of days to finish the meeting
    /*
     * Input: intervals = [(0,40),(5,10),(15,20)]

       Output: 2
     */
    
    public static int meeting2(List<Intervals> intervals) {
    	
    	Collections.sort(intervals, Comparator.comparing(Intervals::getStart));
    	
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Intervals interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }
            minHeap.offer(interval.end);
            System.out.println(" minHeap :::: "+minHeap);
        }
        return minHeap.size();
    	
    }
    
    // overlapping of intervals, how many we can remove to make the list of intervals non-overlaping
    
    public static int makeNonOverlappingInterval(List<Intervals> intervals) { // 1,2  2,3  1,4
    	if(intervals == null || intervals.isEmpty())
    		return 0;
    	int numOfRemoval = 0;
    	int prevEnd = intervals.get(0).getEnd();
    	
    	for(int i=1; i<intervals.size(); i++) {
    		int start = intervals.get(i).getStart();
    		int end = intervals.get(i).getEnd();
    		
    		if(start<prevEnd) {
    			numOfRemoval++;
    		}else {
    		    prevEnd = end;
    		}
    	}
    	return numOfRemoval;
    }

	public static void main(String[] args) {  
		
		TestProgram tp = new TestProgram();
		
		List<Intervals> intervalList = Arrays.asList(new Intervals(1,3), new Intervals(4,6));
		//System.out.println(" after inserting the intervals :::: "+insertIntervals(intervalList, new Intervals(2,5)));
		
		List<Intervals> intervalList1 = Arrays.asList(new Intervals(3,5), new Intervals(6,7), new Intervals(9,10));
		//System.out.println(" after inserting the intervals :::: "+insertIntervals(intervalList1, new Intervals(1,2)));
		
		List<Intervals> intervalList2 = Arrays.asList(new Intervals(1,3), new Intervals(1,5), new Intervals(6,7));
		//System.out.println(" after inserting the intervals :::: "+mergeIntervals(intervalList2));
		
		List<Intervals> intervalList3 = Arrays.asList(new Intervals(1,3), new Intervals(4,5), new Intervals(6,7));
		//System.out.println(" after inserting the intervals :::: "+mergeIntervals(intervalList3));
		
		List<Intervals> intervalList4 = Arrays.asList(new Intervals(1,3), new Intervals(3,5));
		//System.out.println(" after inserting the intervals :::: "+mergeIntervals(intervalList4));
		
		List<Intervals> intervalList5 = Arrays.asList(new Intervals(0,30), new Intervals(5,10), new Intervals(15,20));
		//System.out.println(" can attend meeting :::: "+canAttendMeetings(intervalList5));
		
		List<Intervals> intervalList6 = Arrays.asList(new Intervals(5,8), new Intervals(9,15));
		//System.out.println(" can attend meeting :::: "+canAttendMeetings(intervalList6));
		
		List<Intervals> intervalList7 = Arrays.asList(new Intervals(0,40), new Intervals(5,10), new Intervals(15,20));
		//System.out.println(" can attend meeting :::: "+meeting2(intervalList7));
		
		List<Intervals> intervalList8 = Arrays.asList(new Intervals(0,5), new Intervals(5,10), new Intervals(15,20));
		//System.out.println(" can attend meeting :::: "+meeting2(intervalList8));
		
		List<Intervals> intervalList9 = Arrays.asList(new Intervals(1,2), new Intervals(2,3), new Intervals(1,4));
		System.out.println(" non overlapping intervals :::: "+makeNonOverlappingInterval(intervalList9));
		
		
	}

}

package leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;



public class MergeIntervals {
	
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
	
	// merge intervals - [[1,3],[1,5],[6,7]] 
	
	public static Set<Intervals> mergeIntervals(List<Intervals> intervals){
		if(intervals == null || intervals.isEmpty())
			return new HashSet<>();
		
		Set<Intervals> intlist = new HashSet<>();
		Collections.sort(intervals, Comparator.comparing(Intervals::getStart));
		Intervals a = intervals.get(0);
		
		for(int i=1; i<intervals.size(); i++) {
			
			Intervals b = intervals.get(i);
			
			if(a.getEnd()<b.getStart()) {
				intlist.add(a);
				intlist.add(b);
				a=b;
			}else {
				if(a.getEnd()<b.getEnd()) {
					a = new Intervals(a.getStart(), b.getEnd());
				}
				
				intlist.add(a);
			}
			
		}
		return intlist;
	}
	
	public static List<Intervals> mergeIntervalsWithStack(List<Intervals> intervals){
		if(intervals == null || intervals.isEmpty())
			return new ArrayList<>();
		
		Collections.sort(intervals, Comparator.comparing(Intervals::getStart));
		
		
		Stack<Intervals> stk = new Stack<>();
		stk.push(intervals.get(0));
		
		
		for(int i=1; i<intervals.size(); i++) {   // [[1,3],[3,5],[6,7]]
			Intervals b = intervals.get(i);
			
			Intervals a = stk.peek();
			
			if(a.getEnd()>=b.getStart()) {
				Intervals iv = new Intervals(Math.min(a.getStart(), b.getStart()), Math.max(a.getEnd(), b.getEnd()));
				stk.pop();
				stk.push(iv);
			}else {
				stk.push(b);
			}
		}
		
		return stk;
	}
	
	
	

	public static void main(String[] args) {
       
    	int[] nums = {2,5,4,1,3,8,7,9,6};
    	
    	List<Intervals> intlist = Arrays.asList(new Intervals(1,3), new Intervals(1,5), new Intervals(6,7));
    	System.out.println(" can attend all meetings :::: "+mergeIntervals(intlist));
    	
    	List<Intervals> intlist1 = Arrays.asList(new Intervals(1,2), new Intervals(2,4));
    	System.out.println(" can attend all meetings :::: "+mergeIntervals(intlist1));
    	
        List<Intervals> intlist2 = Arrays.asList(new Intervals(1,5), new Intervals(2,4));
    	System.out.println(" can attend all meetings :::: "+mergeIntervals(intlist2));
    	
    }

}

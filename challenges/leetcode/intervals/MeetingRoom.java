package leetcode.intervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import stages.TestProgram;

public class MeetingRoom {
	
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
		
		
	}
	
	public static boolean canAttendAllMeetings(List<Intervals> intervals) {
		
		if(intervals == null || intervals.isEmpty())
			return false;
	
		Collections.sort(intervals, Comparator.comparingInt(Intervals::getStart));
		System.out.println(" list is :::: "+intervals);
		
		for(int i=0; i<intervals.size()-1;i++) {
			Intervals int1 = intervals.get(i);
			Intervals int2 = intervals.get(i+1);
			
			if(int1.getEnd()>int2.getStart()) {
				return false;
			}
		}
		return true;
		
	}
	
	// minimum number of days to finish meetings
	
	public static int minMeetingRooms(List<Intervals> intervals) { // 0,40 5,10 15,20

		if(intervals == null || intervals.isEmpty())
			return 0;
		
		Collections.sort(intervals, Comparator.comparingInt(Intervals::getStart));
		
		Set<Intervals> inter = new HashSet<>();
		
		for(int i=0; i<intervals.size()-1; i++) {
			Intervals int1 = intervals.get(i);
			Intervals int2 = intervals.get(i+1);
			
			if(int1.getEnd()>int2.getStart()) {
				inter.add(int1);
				if((i+1) == intervals.size()-1) {
					inter.add(int2);
				}
			}else {
				inter.add(int1);
				
			}
			
			
		}
		return inter.size();
    }
	
	public static int minMeetingRoomsNeeded(List<Intervals> intervals) {
		
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Intervals interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }
            minHeap.offer(interval.end);
        }
        return minHeap.size();
    }

	

	public static void main(String[] args) throws InterruptedException {  // 
		
		TestProgram tp = new TestProgram();
		
		List<Intervals> intervals = Arrays.asList(new Intervals(2, 5), new Intervals(6, 8));
	   
	    System.out.println(canAttendAllMeetings(intervals));
	    
	    List<Intervals> intervals1 = Arrays.asList(new Intervals(2, 5), new Intervals(6, 8), new Intervals(3, 10));
		   
	    System.out.println(canAttendAllMeetings(intervals1));
	    
	    List<Intervals> intervals2 = Arrays.asList(new Intervals(0, 40), new Intervals(5, 10), new Intervals(7, 20));
	    System.out.println(minMeetingRooms(intervals2));
		
	}

}

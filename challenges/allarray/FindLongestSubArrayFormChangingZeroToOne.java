package challenges.allarray;

import java.util.ArrayList;
import java.util.List;

import stages.TestProgram;

public class FindLongestSubArrayFormChangingZeroToOne {
	
	/*
	 * Given a binary array, find the index of 0 to be replaced with 1 to get a maximum length sequence of continuous ones.
       For example, consider array { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 }. The index to be replaced is 7 to get a 
       continuous sequence of length 6 containing all 1’s.
	 */
	
	//subarray --- {0,1}, {1,0,1,1,1}, {0,1,1,1}, {1,1,1,0,1,1}
	
	public int findTheLongestSeq1(int[] arr) {
		if(arr == null || arr.length<1)
			return -1;
		
		int i = 0;
		int index = 0;
		List<Integer> elist = new ArrayList<>();
		
		while(i<arr.length-1) {                  //{0, 0, 1, 0, 1, 1, 1, 0, 1, 0}
			
			int j = i+1;
			List<Integer> intlist = new ArrayList<>();
			intlist.add(arr[i]);
			while(j<arr.length) {
				
				if(arr[j] == 0 && intlist.contains(arr[j])) {
				
					if(elist.size()<=intlist.size()) {
						elist = intlist;
						index = i + elist.indexOf(0);
					}
					intlist = new ArrayList<>();
					i++;
					j=i;
					break;
				}else {
					intlist.add(arr[j]);
					j++;
				}
				
				
			}
			
			
			if(j == arr.length) {
				
				if(elist.size()<=intlist.size()) {
					elist = intlist;
					index = i + elist.indexOf(0);
				}
				System.out.println(" intlist ::: "+elist);
				
				break;
			}
			
			
		}
		return index;
	}
	


	public static void main(String[] args) {
    	
		FindLongestSubArrayFormChangingZeroToOne tp = new FindLongestSubArrayFormChangingZeroToOne();
		
		System.out.println(tp.findTheLongestSeq1(new int[] {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}));
		System.out.println(tp.findTheLongestSeq1(new int[] {0, 0, 1, 0, 1, 1, 1, 0, 1, 1}));
        
    }

}

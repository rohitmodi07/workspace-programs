package leetcode.arraysHashing;

public class FindSetOrSubsetContigString {
	
	public static int findMatchesSetOrSubset(String[] sarr) {
		if(sarr == null || sarr.length<1)
			return -1;
		
		int count = 0;
		
		for(int i=0; i<sarr.length; i++) {
			
			String s1 = sarr[i];
			
			for(int j=i+1; j<sarr.length; j++) {
				String s2 = sarr[j];
				
				if(s1.length()>=s2.length()) {
					
					if(s1.substring(0, s2.length()).equals(s2)) {
						count++;
					}
				}else {
					
					if(s2.substring(0, s1.length()).equals(s1)) {
						count++;
					}
				}
				
				
				
			}
			
		}
		
		return count;
	}
    

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5,6,7,8};
		
		String[] sarr = {"abc", "a", "a", "b", "ab", "ac"};
		String[] sarr1 = {"wall", "wallstreet", "phil", "philosophy", "wallet"};
		System.out.println(" number of matches :::: "+findMatchesSetOrSubset(sarr1));
      
	}

}

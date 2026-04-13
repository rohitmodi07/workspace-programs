package leetcode.dynamicprograms;

public class HouseRobSeqAndCircular {
	
	// house robber in staright homes
		// rob1,rob2,num3,num4,...........numn
		
		public static int maxRobStraightWay(int[] hs) {
			if(hs == null || hs.length<1)
				return -1;
			
			if(hs.length == 1) {
				return hs[0];
			}
			if(hs.length == 2) {
				return Math.max(hs[0], hs[1]);
			}
			
			int rob1 = hs[0];
			int rob2 = hs[1];
			
			for(int i=2; i<hs.length; i++) {
				int temp = Math.max(rob2, rob1+hs[i]);
				rob1 = rob2;
				rob2 = temp;
			}
			
			return rob2;
		}
		
		// house robber 2
		
		public static int maxRobCircularHouse(int[] hs) {
			if(hs == null || hs.length<1)
				return -1;
			if(hs.length == 1) {
				return hs[0];
			}
			if(hs.length == 2) {
				return Math.max(hs[0], hs[1]);
			}
			
			return Math.max(robHouse(hs, 0, hs.length-2), robHouse(hs, 1, hs.length-1));
		}


		private static int robHouse(int[] hs, int start, int end) {
			
			int rob1 = hs[start];
			int rob2 = hs[start+1];
			
			for(int i=start+2; i<=end; i++) {
				int temp = Math.max(rob2, rob1+hs[i]);
				rob1 = rob2;
				rob2 = temp;
			}
			
			return rob2;
		}

		public static void main(String[] args) {
	        
			int[] coins = {1,6,2,5,3,7,8};
			
			System.out.println(" max rob :::: "+maxRobCircularHouse(coins));
			
	    }

}

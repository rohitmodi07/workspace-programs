package challenges.hard;

public class CandyDistribution {
	
	public static int distributeCandy(int[] arr) { //1,2,2
		if(arr == null || arr.length<1)
			return -1;
		
		int maxc = 0;
		
		for(int i=0; i<arr.length; i++) {
			
			if(i==0) {                         
				if(arr[i]>arr[i+1]) {
					maxc = maxc + 2;
				}else {
					maxc = maxc + 1;
				}
				
				continue;
			}
			
			if(i < arr.length-1) {
				
				if((arr[i]>arr[i-1] && arr[i]>=arr[i+1]) || (arr[i]<=arr[i-1] && arr[i]>arr[i+1])) {
					maxc = maxc + 2;
				}else {
					maxc = maxc + 1;
				}
			}else {
				if(arr[i]>arr[i-1]) {
					maxc = maxc + 2;
				}else if(arr[i]==arr[i-1]) {
					maxc = maxc + 1;
				}
			}
			
		}
		
		return maxc;
		
	}

	public static void main(String[] args) {
		
		
		int[] arr = {1,0,2};
		System.out.println(" max number of candy ::: "+distributeCandy(arr));
		
		int[] arr1 = {1,2,2};
		System.out.println(" max number of candy ::: "+distributeCandy(arr1));
		
		int[] arr2 = {2, 1, 1, 2, 3, 4, 5, 2, 1};
		System.out.println(" max number of candy ::: "+distributeCandy(arr2));
		
		int[] arr3 = {29,51,87,87,72,12};
		System.out.println(" max number of candy ::: "+distributeCandy(arr3));
	}

}

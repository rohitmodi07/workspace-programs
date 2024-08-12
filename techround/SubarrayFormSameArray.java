package techround;

public class SubarrayFormSameArray {
	
	public static boolean isPartitionPossible(int[] arr) {
		if(arr.length<1)
			return false;
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		if(sum%2 == 0) 
			return true;
		return false;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {2,3,4,5,6};
		System.out.println(" does partition possible :::: "+isPartitionPossible(arr));
		
		int[] arr1 = {1,2,3,4,5,6};
		System.out.println(" does partition possible :::: "+isPartitionPossible(arr1));
		
	}

}

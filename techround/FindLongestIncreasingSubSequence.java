package techround;

public class FindLongestIncreasingSubSequence {

	public static int findLongestIncSubSequence(int[] arr) {
		if(arr.length<1)
			return -1;
		int max = 0;
		
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]<arr[j] && arr[j-1]<arr[j]) {
					count++;
				}
			}
			max = count>max ? count : max;
		
		}
		
		return max;
		
	}
	

	public static void main(String[] args) {
		
		int[] arr = {10,9,2,5,3,7,101,18};
		System.out.println(" The longest increasing subsequence is ::: "+findLongestIncSubSequence(arr));
		
		int[] arr1 = {0,1,0,3,2,3};
		System.out.println(" The longest increasing subsequence is ::: "+findLongestIncSubSequence(arr1));
		
		int[] arr2 = {5,5,5,5,5};
		System.out.println(" The longest increasing subsequence is ::: "+findLongestIncSubSequence(arr2));
	}
}

package challenges.allarray;

public class PerformSearchAndFindMinRotatedArray {
	
	public static int findMinInRotatedArray(int[] arr) {  // 3,4,5,6,1,2    4,5,6,1,2,3     5,6,1,2,3,4 
		if(arr == null || arr.length<1)
			return -1;
		int start = 0;
		int end = arr.length-1;
		
		while(start<end) {
			int mid = (start+end)/2;
		
			System.out.println(" start is :::: "+start);
			System.out.println(" end is :::: "+end);
			System.out.println(" mid is :::: "+mid);
			if(arr[mid]<arr[end]) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		System.out.println(" start at the end ::: "+start);
		return arr[start];
	}
	
	public static boolean binarySearchKey(int[] arr, int key) {
		if(arr == null || arr.length<1)
			return false;
		int start=0;
		int end=arr.length-1;
		
		while(start<=end) {
			int mid = (start + end)/2;
			if(key == arr[mid]) {
				return true;
			}else if(key>arr[mid]) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return false;
	}
	
	public static boolean searchInRotatedArray(int[] arr, int key) {
		if(arr == null || arr.length<1)
			return false;
		int start=0;
		int end=arr.length-1;
		
		while(start<=end) {               // 5,6,1,2,3,4  3,4,5,6,7,1,2
			int mid = (start + end)/2;
			if(key == arr[mid]) {
				return true;
			}else if((arr[mid]<arr[end] && key<arr[end]) || (arr[mid]>arr[end] && key<=arr[end])) {
				start = mid+1;
			}else if(arr[mid]>arr[end] && key<arr[mid]) {
				end = mid-1;
			}else {
				start++;
				end--;
			}
		}
		return false;
	}
	

	public static void main(String[] args) throws Exception {

		int[] arr = {5,6,7,8,9,1,2,3};
		System.out.println(" does element exist ::: "+searchInRotatedArray(arr, 2));
		System.out.println(" does element exist ::: "+searchInRotatedArray(arr, 8));
		System.out.println(" does element exist ::: "+searchInRotatedArray(arr, 10));
		
		int[] arr1 = {1,2,3,4,5,7,8,10};
		//System.out.println(" does key 4 exist :: "+binarySearchKey(arr1, 4));
		//System.out.println(" does key 6 exist :: "+binarySearchKey(arr1, 6));
		//System.out.println(" does key 10 exist :: "+binarySearchKey(arr1, 10));
		//System.out.println(" does key 9 exist :: "+binarySearchKey(arr1, 9));
		
	}

}

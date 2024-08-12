package challenges.allarray;

import java.util.Arrays;
import java.util.Optional;

public class SeparateZeroOneNegPos {
	
	public static int[] moveZerosToRight(int[] arr) {
		if(arr == null || arr.length<1)
			return null;
		int count = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>0) {
				arr[count] = arr[i];
				count++;
			}
		}
		while(count<arr.length) {
			arr[count] = 0;
			count++;
		}
		return arr;
	}
	
	public static int[] moveZerosToLeft(int[] arr) {
		if(arr == null || arr.length<1)
			return null;
		int count = arr.length-1;
		for(int i=arr.length-1; i>=0; i--) {
			if(arr[i]>0) {
				arr[count] = arr[i];
				count--;
			}
		}
		while(count>=0) {
			arr[count] = 0;
			count--;
		}
		return arr;
	}
	
	public static int[] separateZeroAndOne(int[] arr) {
		if(arr == null || arr.length<1)
			return null;
		int i=0;
		int j=arr.length-1;
		
		while(i<j) {
			if(arr[i] == 0 && arr[j] == 1) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
				i++;
				j--;
			}else if(arr[i] == 1) {
				i++;
			}else if(arr[j] == 0) {
				j--;
			}
		}
		
		return arr;
	}
	
	
	public static int[] separateZeroAndOne1(int[] arr) {
		if(arr == null || arr.length<1)
			return null;
		int i=0;
		int j=arr.length-1;
		
		while(i<j) {
			if(arr[i] == 1 && arr[j] == 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
				i++;
				j--;
			}else if(arr[i] == 0) {
				i++;
			}else if(arr[j] == 1) {
				j--;
			}
		}
		
		return arr;
	}
	
	public static Optional<int[]> separateZeroNegPos(int[] arr) {
		if(arr == null || arr.length<1)
			return Optional.empty();
		int i=0;
		int j=arr.length-1;
		
		while(i<j) {
			if(arr[i] != 0 && arr[j] == 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
				i++;
				j--;
			}else if(arr[i] == 0) {
				i++;
			}else if(arr[j] != 0) {
				j--;
			}
		}
		
		
		return Optional.of(arr);
	}
	
	public static Optional<int[]> separateZeroNegPos1(int[] arr) {
		if(arr == null || arr.length<1)
			return Optional.empty();
		int i=0;
		int j=arr.length-1;
		
		while(i<j) {
			if(arr[i]>=0 && arr[j]<0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
				i++;
				j--;
			}else if(arr[i]<0) {
				i++;
			}else if(arr[j]>=0) {
				j--;
			}
		}
		
		
		
		System.out.println(" i :: "+i);
		System.out.println(" j :: "+j);
		
		j = arr.length-1;
		
		while(i<j) {
			if(arr[i]>0 && arr[j] == 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
				i++;
				j--;
			}else if(arr[i] == 0) {
				i++;
			}else if(arr[j]>0) {
				j--;
			}
		}
		
		return Optional.of(arr);
	}
	

	public static void main(String[] args) {
		    	
		//int[] arr = {1,1,0,0,1,0,1,0,1,1,0};
		//System.out.println(" zeros and ones :::: "+Arrays.toString(moveZerosToRight(arr)));
		
		//int[] arr1 = {1,1,0,0,1,0,1,0,1,1,0};
		//System.out.println(" zeros and ones :::: "+Arrays.toString(moveZerosToLeft(arr1)));
		
		//int[] arr1 = {1,1,0,0,1,0,1,0,1,1,0};
		//System.out.println(" zeros and ones :::: "+Arrays.toString(separateZeroAndOne1(arr1)));
		
		int[] arr1 = {1,-1,0,0,2,0,3,0,-4,0,5};
		System.out.println(" zeros and ones :::: "+Arrays.toString(separateZeroNegPos1(arr1).get()));
		
		
    }

}

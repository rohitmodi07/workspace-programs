package challenges.allarray;

import java.util.Arrays;

public class RotateArrayAndItsRelatedProgram {
	
	public static int[] rotateTheArray(int[] arr, int k) {
		if(arr.length<1 || k<1)
			return null;
		rotate(arr, 0, k-1);
		rotate(arr, k, arr.length-1);
		rotate(arr, 0, arr.length-1);
		
		return arr;
	}
	
	public static void rotate(int[] arr, int start, int end) {
		while(start<end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
		}
	}
	
	public static int getMinFromRotatedArray(int[] varray) {
		if(varray.length<1)
			return -1;
		
		int j = varray.length-1;
		
		while(j>0) {
			if(varray[j]>varray[j-1]) {
				j--;
			}else {
				break;
			}
		}
		
		return varray[j];
	}
	
	public static boolean searchInRotatedArray(int[] varray, int k) {
		if(varray.length<1 || k<0)
			return false;
		int firstval = varray[0];
		int lastval = varray[varray.length-1];
		if(k<=firstval) {
			int j = varray.length-1;
			while(j>0) {
				if(k == varray[j]) {
					return true;
				}else {
					j--;
				}
			}
		}else if(k>lastval){
			int j = 0;
			while(j<(varray.length-1)) {
				if(k == varray[j]) {
					return true;
				}else {
					j++;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		int[] arr = {3,4,5,6,7,8,9};
		
		int[] varray = rotateTheArray(arr, 3);
		
		System.out.println(Arrays.toString(varray));
		
		System.out.println(getMinFromRotatedArray(varray));
		
		System.out.println(searchInRotatedArray(varray, 4));
		
		System.out.println(searchInRotatedArray(varray, 8));
		
		System.out.println(searchInRotatedArray(varray, 10));
		
	}

}

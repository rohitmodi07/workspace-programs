package techround;

import java.util.Arrays;

import stages.TestProgram;

public class RotateArrayLeftAndRight {
	
	//rotation , array, direction
	
	public void rotateTheArray(int[] numarr, int numOfRotation, String direction) {
		
		if(numarr.length<1)
			return;
		
		while(numOfRotation>numarr.length) {   //8, 16
			numOfRotation = numOfRotation - numarr.length;
		}
		
		System.out.println("numOfRotation :::: "+numOfRotation);
		
		if("left".equalsIgnoreCase(direction)) {
			rotateNumbers(numarr, 0, numOfRotation-1);
			rotateNumbers(numarr, numOfRotation, numarr.length-1);
			rotateNumbers(numarr, 0, numarr.length-1);
		}else if("right".equalsIgnoreCase(direction)) {
			/*
			 * 1,2,3,4,5,6,7  ,  7-2 = 5
			 * rotate arr.length-rotation to arr.length-1
				rotate 0 to arr.length-rotation
				
				rotate 0 to arr.length-1;
			 */
			
			rotateNumbers(numarr, (numarr.length)-(numOfRotation), numarr.length-1);
			
			rotateNumbers(numarr, 0, numarr.length-1-numOfRotation);
			
			rotateNumbers(numarr, 0, numarr.length-1);
			
		}
		
		System.out.println(Arrays.toString(numarr));
		
		
	}
	
	public void rotateNumbers(int[] arr, int begin, int end) {
		
		while(begin<end) {
			int temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;
			
			begin++;
			end--;
		}
		
	}
	
	

	public static void main(String[] args) {
		
		//TestProgram tpg = new TestProgram();
		
		int[] numarr = {1,2,3,4,5,6,7};
		
		//tpg.rotateTheArray(numarr, 9, "right");

	}

}

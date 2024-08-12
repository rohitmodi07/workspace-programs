package techround.microsoft;

public class FindPeakElement {

	//5,10,20,15    10,20,30,40,50      50,40,30,20
	
		public static int getPeakElement(int[] arr) {
			if(arr == null || arr.length<1)
				return 0;
			
			int peak = 0;
			//int j=0;
			if(arr.length == 1)
				return 0;
			if(arr.length == 2) {
				if(arr[0]>arr[1]) {
					return arr[0];
				}else {
					return arr[1];
				}
			}
			
			int i = 1;
			
			boolean findpeak = false;
			
			while(i<arr.length-1) {
				if(arr[i]>arr[i-1] && arr[i]>arr[i+1]) {
					peak = Math.max(peak, arr[i]);
					findpeak = true;
					break;
				}else if(arr[i]>arr[i-1] && arr[i]<arr[i+1]) {
					findpeak = true;
					i++;
				}else if(arr[i]<arr[i-1]){
					i++;
				}
			}
			
			if(findpeak) {
				peak = peak == 0 ? arr[i] : peak;
			}else {
				peak = arr[0];
			}
			
			
			
			return peak;
		}


		public static void main(String[] args) {
			
			int[] arr = {5,10,20,15};
			
			System.out.println(" get the peak element ::::: "+getPeakElement(arr));
			
	        int[] arr1 = {5,10,20,30};
			
			System.out.println(" get the peak element ::::: "+getPeakElement(arr1));
			
	        int[] arr2 = {50,40,30,20,10};
			
			System.out.println(" get the peak element ::::: "+getPeakElement(arr2));
			
	        int[] arr3 = {10,20};
			
			System.out.println(" get the peak element ::::: "+getPeakElement(arr3));
			
		}

}

package challenges.allarray;

public class MultiplyTwoString {
	
	public static int multiply (char A[], char B[]){
		int totalSum = 0, sum = 0;
		for (int i = 0; i < A.length; i++){
			sum = 0;

			for (int j = 0; j < B.length; j++){
				sum *= 10;
				sum += (A[i] - '0') * (B[j] - '0');
				
			}
			totalSum *=10;
			totalSum += sum;
		}

		return totalSum;
	}

	public static void main(String[] args) throws InterruptedException { 
		
          
		  System.out.println(" total prod ::: "+multiply("25".toCharArray(), "25".toCharArray()));
		
    }

}

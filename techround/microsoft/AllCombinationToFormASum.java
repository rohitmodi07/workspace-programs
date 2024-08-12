package techround.microsoft;

public class AllCombinationToFormASum {
	
	public static void allCombination(int num) {
		if(num <1)
			return;
		int[] arr = new int[num];
		
		printCompositions(arr, num, 0, num-1);
			
	}
	
	static void printCompositions(int[] arr, int num, int start, int end)
    {
        
        if (num == 0)
        {
            printArray(arr, start);
        }
        else if(num > 0)
        {
            for (int k = 1; k <= end; k++)
            {
                arr[start]= k;
                printCompositions(arr, num-k, start+1, end);
            }
        }
    }
     
    // Utility function to print array arr[] 
    static void printArray(int arr[], int m)
    {
        for (int i = 0; i < m; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


	public static void main(String[] args) {
		
		System.out.println(" all combinations ::::: ");
		int[] arr = {1,2,3,4,5};
		
		allCombination(arr.length);
		
		  
	}

}

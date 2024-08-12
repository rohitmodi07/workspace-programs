package challenges.allarray;

public class CharacterReplacement {
	
	/*
	 * Input: s = "ABAB", k = 2
       Output: 4
       Explanation: Replace the two 'A's with two 'B's or vice versa.
	 */
	
	public static int characterReplacement(String s, int k) {
        // Initializing an empty array to store the count of the 
        // characters in the given string s
        int[] arr = new int[26];   //
        int res = 0;
        int max = 0;

        // The left pointer for the sliding window is l AND r is the 
        // right pointer
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
        	int val = s.charAt(r) - 'A';
            // Counting the number of each character in the string s
            arr[val]++;
            
            System.out.println(" val :::: "+val);
            System.out.println(" arr :::: "+arr[val]);

            // Checking the character with max number of occurrence
            max = Math.max(max, arr[val]);

            // Now we check if our current window is valid or not
            if (r - l + 1 - max > k) { 
            // this means the no. of replacements is more than
            // allowed (k)
                // Decrementing the count of the character which was 
                // at l because it is no longer in the window
            	int val1 = s.charAt(l) - 'A';
                arr[val1]--;
                l++;
            }

            // The max our window can be
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
	

	public static void main(String[] args) {
		
		System.out.println(" len after replacing :::: "+characterReplacement("ABAB", 2));
	   
    }

}

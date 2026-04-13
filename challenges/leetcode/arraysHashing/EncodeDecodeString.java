package leetcode.arraysHashing;

import java.util.Arrays;


public class EncodeDecodeString {
	
	// encode decode string
		/*
		 * Input: ["neet","code","love","you"]

	       Output:["neet","code","love","you"]

		 */
		
		public static String encodeString(String[] sarr) {
			if(sarr == null || sarr.length<1)
				return "";
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<sarr.length; i++) {
				sb.append(sarr[i]);
				sb.append("#");
			}
			return sb.toString();
		}
		
		public static String[] decodeString(String st) {
			if(st == null || st.isEmpty())
				return null;
			String[] sarr = st.split("#");
			
			return sarr;
		}
		

		public static void main(String[] args) {

			
			String[] sarr = {"we","say",":","yes"};
			String encodedString = encodeString(sarr);
			System.out.println(" endocing string array to string ::: "+encodedString);
			
			String[] decodedStringToArray = decodeString(encodedString);
			System.out.println(" decoded back to string array :::: "+Arrays.toString(decodedStringToArray));
			
		}

}

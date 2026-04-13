package leetcode.twoPointers;

public class ValidPalindrome {
	
	public static boolean validPalindrome(String st) {
		if(st == null || st.isEmpty())
			return false;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<st.length(); i++) {
			char cr = st.charAt(i);
			
			if(Character.isLetter(cr)) {
				sb.append(String.valueOf(cr).toLowerCase());
			}
		}
		return sb.toString().equals(sb.reverse().toString());
		
	}
	
	

	public static void main(String[] args) {

		
		System.out.println(" valid palindrome :::: "+validPalindrome("Was it a car or a cat I saw?"));
		System.out.println(" valid palindrome :::: "+validPalindrome("tab a cat"));
		
		
	}

}

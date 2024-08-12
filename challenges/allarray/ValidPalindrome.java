package challenges.allarray;

public class ValidPalindrome {
	
	public static boolean isValidPalindrome(String str) {
		if(str.isEmpty())
			return true;
		int i = 0;
		int j = str.length()-1;
		
		while(i<j) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static boolean isValidPalindrome1(String str) {
		if(str.isEmpty())
			return true;
		
		char[] c = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<c.length; i++) {
			if(Character.isLetter(c[i])) {
				sb.append(String.valueOf(c[i]).toLowerCase());
			}
		}
		
		System.out.println("validStr   ::: "+sb.toString());
		
		return isValidPalindrome(sb.toString());
	}
	

	public static void main(String[] args) {
		int[] narr = {2,4,5,6,1};
		
		System.out.println(" is valid palindorme ::::: "+isValidPalindrome1("aaba"));
		System.out.println(" is valid palindorme1 ::::: "+isValidPalindrome1("A man, a plan, a canal: Panama"));
		System.out.println(" is valid palindorme1 ::::: "+isValidPalindrome1("race a car"));
		
    }

}

package challenges.allarray;

public class CharWithOccFormString {
	
	public static String formString(String str) {
		if(str == null || str.isEmpty())
			return "";
		
		int count = 0;
		char curr = str.charAt(0);
		String result = "";
		
		for(int i=0; i<=str.length(); i++) {
			if(i != str.length() && curr == str.charAt(i)) {
				count++;
			}else if(i == str.length()) {
				result = result + curr + count;
				break;
			}else {
				result = result + curr + count;
				count = 1;
				curr = str.charAt(i);
			}
		}
		
		return result;
	}
	

	public static void main(String[] args) {
		
		System.out.println(formString("aabbbaa"));
		
	}

}

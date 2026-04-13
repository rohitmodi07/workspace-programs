package challenges.allarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListEncodeStringDecode {
	
	/*
	 * Input: ["neet","code","love","you"]

       Output:["neet","code","love","you"]

	 */
	
	public static String encodeList(List<String> slist) {
		if(slist == null || slist.isEmpty())
			return "";
		StringBuilder sb = new StringBuilder();
		String cstr = "#";
		for(String st : slist) {
			
			char[] c = st.toCharArray();
			
			for(int i=c.length-1; i>=0; i--) {
				cstr = cstr+c[i];
			}
			cstr = cstr+"#";
		}
		return cstr;
	}
	
	public static List<String> decodeString(String str){
		if(str == null || str.isEmpty())
			return new ArrayList<>();
		
		char[] c = str.toCharArray();
		List<String> slist = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<c.length; i++) {
			if(Character.isLetter(c[i])) {
				sb.append(c[i]);
			}else {
				slist.add(sb.reverse().toString());
				sb = new StringBuilder();
			}
		}
		return slist;
	}
	

	public static void main(String[] args) {
    	
		String val = encodeList(Arrays.asList("neet","code","love","you"));
    	System.out.println(" encode list and return as string ::: "+val);
    	System.out.println(" decode string and return as list ::: "+decodeString(val));
    	
    }

}

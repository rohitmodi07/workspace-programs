package challenges.allarray;

public class ExcelColumnNameToNumAndVV {
	
	public static String getExcelColumnNames(int num) {
		//null check
		if (num < 1) {
            return null;
        }
		
		StringBuilder sb = new StringBuilder();
		
		while(num>0) {
			
			int remainder = (num-1)%26;
			
			sb.append((char)(remainder + 'A'));
			
			num = (num-1)/26;
		}
		
        return sb.reverse().toString();
		
	}
	
	public static int getExcelNumber(String str) {
		//check if the string is not empty
		if (str == null || str.length() == 0) {
            return 0;
        }
        
        int sum = 0;
        
        for (int i = 0; i < str.length(); i++) {
            
            int num = str.charAt(i) - 'A' + 1;
            
            sum += num * Math.pow(26, str.length()-i-1);
        }
		
		
		return sum;
	}
	
	public static int getExcelColumnNumberBasedOnColumnName(String str) {
		
		if(str.isEmpty()) {
			return 0;
		}
		
		int columnNumber = 0;
		
		for(int i=0; i<str.length(); i++) {
			int num = str.charAt(i) - 'A' + 1;
			
			System.out.println("----------"+num * Math.pow(26, str.length()-i-1));
			
			columnNumber = (int) (columnNumber + num * Math.pow(26, str.length()-i-1));
		}
		
		return columnNumber;
		
	}
	
	public static int getAllPossiblePalindrom(String str) {
		
		if(str.isEmpty())
			return 0;
        
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
        	
        	count += helper(str, i, i);
        	count += helper(str, i, i+1);
        }
        
        return count;
        
	}
	
	public static int helper(String str, int begin, int end) {
		
		int count = 0;
		
		while(begin>=str.length()-1 && end<=str.length()-1 && str.charAt(begin) == str.charAt(end)) {
			begin--;
			end++;
			count++;
		}
		return count;
		
	}
	    
    public static void main(String[] args) {
     
    	System.out.println(getExcelColumnNames(11));
    	System.out.println(getExcelColumnNames(26));
    	System.out.println(getExcelColumnNames(29));
    	
    	
    	System.out.println(getExcelNumber("K"));
    	System.out.println(getExcelNumber("Z"));
    	System.out.println(getExcelNumber("AC"));
    	
    	System.out.println(getExcelColumnNumberBasedOnColumnName("K"));
    	System.out.println(getExcelColumnNumberBasedOnColumnName("Z"));
    	System.out.println(getExcelColumnNumberBasedOnColumnName("AC"));
    	
    	System.out.println(getAllPossiblePalindrom("AAA"));
    }

}

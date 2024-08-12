package challenges.allarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentListSorting {
	
    public static List<String> getFilteredNames(List<List<String>> studentList){
		
		
		return null;
	}
	    
	    
    public static void main(String[] args) {
        List<String> str1 = Arrays.asList("Aman", "Derek");
        List<String> str2 = Arrays.asList("Aakash", "Mack");
        List<String> str3 = Arrays.asList("Cena", "John");
        
        List<List<String>> namelist = new ArrayList<>();
        namelist.add(str1);
        namelist.add(str2);
        namelist.add(str3);
        
        List<String> filteredList = getFilteredNames(namelist);
    }

}

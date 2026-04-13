package challenges.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamApiImpConcept {
	
   private static class Employee{
		
		private int empId;
		private String empName;
		private int salary;
		private String dept;
		
		public Employee(int empId, String empName, int salary, String dept) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.salary = salary;
			this.dept = dept;
		}

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public String getDept() {
			return dept;
		}

		public void setDept(String dept) {
			this.dept = dept;
		}

		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", dept=" + dept + "]";
		}
		
	}


	public static void main(String[] args) throws InterruptedException {
		
		List<Employee> emplist = Arrays.asList(new Employee(20, "john", 200, "humanre resource"),
											   new Employee(10, "cena", 100, "facility"),
											   new Employee(40, "kelly", 400, "research"),
											   new Employee(50, "mack", 500, "development"),
											   new Employee(30, "sam", 300, "admin"));
		
		// filter the list
		
		List<Employee> filteredList = emplist.stream().filter(emp -> emp.getEmpId()>30).toList();
		//System.out.println(" filtered list :::: "+filteredList);
		
		// get all the names
		
		List<String> allNames = emplist.stream().filter(emp -> emp.getEmpId()>10)
				.map(Employee::getEmpName).sorted().collect(Collectors.toList());
		//System.out.println(" name list ::::: "+allNames);
		
		//sort
		//System.out.println(" before sorting :::: "+emplist);
		List<Employee> sortedList = emplist.stream().sorted(Comparator.comparing(Employee::getEmpId)).toList();
		//System.out.println(" sorted list ::::: "+sortedList);
		
		//flat map
		
		Employee emp1 = new Employee(20, "john", 200, "humanre resource");
		Employee emp2 = new Employee(10, "cena", 100, "facility");
		Employee emp3 = new Employee(40, "kelly", 400, "research");
		Employee emp4 = new Employee(50, "mack", 500, "development");
		Employee emp5 = new Employee(30, "sam", 300, "admin");
		
		Employee[][] emparr = {{emp1},{emp2},{emp3},{emp4},{emp5}};
		Stream<Employee[]> st = Stream.of(emparr);
		
		List<Employee> flattenList = st.flatMap(emp -> Arrays.stream(emp)).toList();
		//System.out.println(" flatten list :::: "+flattenList);
		
		// convert to map
		
		Map<Integer, Employee> emap = emplist.stream().collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
		//System.out.println(" converted map :::: "+emap);
		
		List<Integer> lst = Arrays.asList(1,2,3,4,2,3,5,6);
		Set<Integer> hset = new HashSet<>();
		
		List<Integer> arrlist = lst.stream().filter(val -> !hset.add(val)).toList();
		//System.out.println(" unique numbers ::: "+arrlist);
		
		List<Integer> ilist = Arrays.asList(1,2,3,4,5,6);
		
		double sum = ilist.stream().mapToInt(Integer::intValue).average().getAsDouble();
		//System.out.println(" sum ::: "+sum);
		
		Map<String, Integer> smap = Map.of(
				    "two", 2,
				    "one", 1,
				    "three", 3,
				    "five", 5,
				    "four", 4
				);
		
		
		//System.out.println(" map before sorted :::: "+smap);
		Map<String, Integer> sortedMap = smap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)->e2, LinkedHashMap::new));
		//System.out.println(" sorted map :::: "+sortedMap);
		
		List<String> names = List.of("john", "cena", "kelly", "sam");
		List<String> upperCaseNames = names.stream().map(String::toUpperCase).toList();
		
		
		List<Integer> lst1 = Arrays.asList(1,2,3,4,2,3,5,6);
		int uniquelist = lst1.stream().max(Integer::compare).orElse(null);
		
		//Count Strings with Prefix: Given a list of strings and a prefix string, count how many strings in the list start with the given prefix. 
		
	    List<String> words = Arrays.asList("apple", "application", "banana", "app");
	    String prefix = "app";
	    
	    long count = words.stream().filter(s -> s.startsWith(prefix)).count();
	    
	    //Find First Non-Repeated Character: Given a string, find and return the first non-repeated character. 
	    
	    String str = "swiss";
	    
	    char firstNonRepChar = str.chars().mapToObj(i -> (char)i).filter(c -> str.indexOf(c) == str.lastIndexOf(c))
	    		.findFirst().orElse(null);
		
		//System.out.println(" first non repeated char :::: "+firstNonRepChar);
		
		//Group by Length: Given a list of strings, group the strings based on their lengths. 
	    List<String> fewwords = Arrays.asList("a", "ab", "abc", "abcd", "ab");
	    Map<Integer, List<String>> wordMap = fewwords.stream().collect(Collectors.groupingBy(String::length));
	    System.out.println(" word map with length ::::: "+wordMap);
	    
		
		
	}

}

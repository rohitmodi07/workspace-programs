package challenges.allarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamExample {
	
	private static class Employee {
    	private String empName;
    	private int empId;
    	private String city;
    	private int salary;
    	
		public Employee(String empName, int empId, String city, int salary) {
			super();
			this.empName = empName;
			this.empId = empId;
			this.city = city;
			this.salary = salary;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [empName=" + empName + ", empId=" + empId + ", city=" + city + ", salary=" + salary + "]";
		}
    	
    }


	public static void main(String[] args) {
		int[] arr = {7,1,5,3,6,4};
		
		List<Employee> empList = Arrays.asList(new Employee("John", 100, "Dallas", 10000),
				new Employee("Cena", 200, "Texas", 20000), new Employee("Mack", 300, "Denver", 30000),
				new Employee("Sach", 400, "Seatle", 40000), new Employee("Larry", 500, "Dallas", 50000));
		
		List<Employee> e1 = empList.stream().filter(emp -> emp.getEmpId()>200).collect(Collectors.toList());
		
		System.out.println(" e1 :::: "+e1);
		
		List<String> e2 = empList.stream().filter(emp -> emp.getEmpId()>200)
				          .map(Employee :: getEmpName).collect(Collectors.toList());
		
		System.out.println(" e2 :::: "+e2);
		
		List<Employee> e3 = empList.stream().sorted(Comparator.comparing(Employee :: getEmpName)).collect(Collectors.toList());
		
		System.out.println(" e3 :::: "+e3);
		
		int maxSal = empList.stream().mapToInt(Employee :: getSalary).max().getAsInt();
		double averageSalary = empList.stream().mapToInt(Employee :: getSalary).average().getAsDouble();
		
		System.out.println(" max sal :::: "+maxSal);
		System.out.println(" max sal :::: "+averageSalary);
		
		int[] arr1 = {1,2,3,4,5,6};
		int[] arr2 = {5,6,7,8,9,10};
		
		Stream<Integer> s1 = Arrays.stream(arr1).boxed();
		Stream<Integer> s2 = Arrays.stream(arr2).boxed();
		
		int[] result = Stream.concat(s1, s2).distinct().mapToInt(Integer :: intValue).toArray();
		
		System.out.println(" result :::: "+Arrays.toString(result));
		
		String[][] strarr = {{"A", "C"}, {"D", "B"}, {"E"}};
		Stream<String[]> sarr = Stream.of(strarr);
		
		List<String> alpha = sarr.flatMap(alp -> Arrays.stream(alp)).sorted().collect(Collectors.toList());
		
		System.out.println(" alpha :::: "+alpha);
		List<String> l1 = Arrays.asList("C", "D", "A", "B");
		List<String> l2 = Arrays.asList("F", "E", "H", "G");
		List<String> l3 = Arrays.asList("K", "I", "J");
		
		List<List<String>> emp = Arrays.asList(l1, l2, l3);
		
		List<String> aplist = emp.stream().flatMap(lst -> lst.stream()).sorted().collect(Collectors.toList());
		
		System.out.println(" aplist :::::: "+aplist);
		
		
    }

}

package techround;

import java.util.LinkedHashMap;
import java.util.Map;


public class LeastRecentUsedWithMap {
	
	private static class Employee{
		private int empId;
		private String empName;
		private String empDept;
		
		public Employee(int empId, String empName, String empDept) {
			this.empId = empId;
			this.empName = empName;
			this.empDept = empDept;
		}
	}
	
	private int capacity;
	private Map<Integer, Employee> empMap;
	
	public LeastRecentUsedWithMap(int capacity) {
		this.capacity = capacity;
		empMap = new LinkedHashMap<>(capacity);
	}
	
	public boolean pushEmployee(Employee emp) {
		if(emp == null)
			return false;
		if(empMap.containsKey(emp.empId)) {
			pickEmployee(emp);
		}else if(capacity == empMap.size()) {
			int empkey = empMap.entrySet().iterator().next().getKey();
			empMap.remove(empkey);
			empMap.put(emp.empId, emp);
		}else {
			empMap.put(emp.empId, emp);
		}
		
		return true;
	}
	
	public boolean removeEmployee() {
		if(empMap.size()>0) {
			int empKey = empMap.entrySet().iterator().next().getKey();
			empMap.remove(empKey);
			return true;
		}
		return false;
	}
	
	public void pickEmployee(Employee emp) {
		
		int empKey = empMap.entrySet().iterator().next().getKey();
		empMap.remove(empKey);
		empMap.put(emp.empId, emp);
	}
	
	public void display() {
		for(Map.Entry<Integer, Employee> e : empMap.entrySet()) {
			System.out.println(" Employee object is : {"+e.getKey()+", "+e.getValue()+"}");
		}
	}

	public static void main(String[] args) {
		
		Employee emp1 = new Employee(350, "John", "IT");
		Employee emp2 = new Employee(250, "Cena", "HR");
		Employee emp3 = new Employee(300, "Rock", "ADMIN");
		Employee emp4 = new Employee(200, "Mack", "FACILITY");
		Employee emp5 = new Employee(150, "Serli", "SUPPORT");
		
		LeastRecentUsedWithMap lru = new LeastRecentUsedWithMap(6);
		
		lru.pushEmployee(emp1);
		lru.pushEmployee(emp2);
		lru.pushEmployee(emp3);
		lru.pushEmployee(emp4);
		lru.pushEmployee(emp5);
		
		System.out.println(" pushing following 5 employees in the Map : : :");
		lru.display();
		
		lru.pushEmployee(emp1);
		
		System.out.println(" since we are trying to push existing employee "+emp1.empId+", now it should be newest employee in the Map : : :");
		lru.display();
		
		Employee emp6 = new Employee(100, "Merry", "DEV-OPS");
		
		lru.pushEmployee(emp6);
		
		System.out.println(" after pushing 6th employee "+emp6.empId+", the Map contains : : :");
		lru.display();
		
		Employee emp7 = new Employee(50, "cherry", "PLATFORM");
		
		lru.pushEmployee(emp7);
		
		System.out.println(" adding 7th employee "+emp7.empId+", since size of Map is 6, it will remove the oldest employee "
		                     +emp2.empId+" and add this employee : : :");
		lru.display();

	}

}

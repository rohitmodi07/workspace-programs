package techround;

import java.util.Set;
import java.util.LinkedHashSet;

public class LeastRecentUsedWithSet {
	
	private static class Employee{
		private int empId;
		private String empName;
		
		public Employee(int empId, String empName) {
			this.empId = empId;
			this.empName = empName;
		}

		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName + "]";
		}
		
	}
	
	private int capacity;
	private Set<Employee> empset;
	
	public LeastRecentUsedWithSet(int capacity) {
		this.capacity = capacity;
		empset = new LinkedHashSet<>(capacity);
	}
	
	public boolean pushEmployee(Employee employee) {
		
		if(employee == null)
			return false;
		if(empset.contains(employee)) {
			putIfEmployeeExist(employee);
		}else if(capacity == empset.size()) {
			Employee emp = empset.iterator().next();
			empset.remove(emp);
			empset.add(employee);
		}else {
			empset.add(employee);
		}
		return true;
		
	}
	
	public boolean popEmployee() {
		if(empset.size()>0) {
			Employee emp = empset.iterator().next();
			empset.remove(emp);
			return true;
		}
		return false;
	}

	public void putIfEmployeeExist(Employee emp) {
		
		empset.remove(emp);
		empset.add(emp);
	}
	
	public void display() {
		for(Employee e : empset) {
			System.out.println(" Employee object is : "+e.toString());
		}
	}
	
	public static void main(String[] args) {
		
		Employee emp1 = new Employee(350, "John");
		Employee emp2 = new Employee(250, "Cena");
		Employee emp3 = new Employee(300, "Rock");
		Employee emp4 = new Employee(200, "Mack");
		Employee emp5 = new Employee(150, "Serli");
		
		LeastRecentUsedWithSet lru = new LeastRecentUsedWithSet(6);
		
		lru.pushEmployee(emp1);
		lru.pushEmployee(emp2);
		lru.pushEmployee(emp3);
		lru.pushEmployee(emp4);
		lru.pushEmployee(emp5);
		
		System.out.println(" pushing following 5 employees in the Set : : :");
		lru.display();
		
		lru.pushEmployee(emp1);
		
		System.out.println(" since we are trying to push existing employee "+emp1.empId+", now it should be newest employee in the Set : : :");
		lru.display();
		
		Employee emp6 = new Employee(100, "Merry");
		
		lru.pushEmployee(emp6);
		
		System.out.println(" after pushing 6th employee "+emp6.empId+", the Set contains : : :");
		lru.display();
		
		Employee emp7 = new Employee(50, "cherry");
		
		lru.pushEmployee(emp7);
		
		System.out.println(" adding 7th employee "+emp7.empId+", since size of Set is 6, it will remove the oldest employee "
                             +emp2.empId+" and add this employee : : :");
		lru.display();

	}

}

package challenges.multi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class ExecutorCompletionServiceDemo {
	
	private static class Employee{
		private int empId;
		private String empName; 
		private int salary;
		
		public Employee(int empId, String empName, int salary) {
			this.empId = empId;
			this.empName = empName;
			this.salary = salary;
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

		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
		}
		
	}
	
	

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		List<Employee> empList = Arrays.asList(new Employee(100, "john", 1000), new Employee(300, "cena", 3000),
				new Employee(200, "kelly", 2000));
		
		ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		CompletionService<Integer> execComplServ = new ExecutorCompletionService<>(exec);
		
		List<Future<Integer>> futlist = new ArrayList<>();
		
		for(Employee emp : empList) {
			
			Future<Integer> ft = execComplServ.submit(new Callable<>() {
				
				public Integer call() {
					
					long start = new Date().getTime();
					
				   int id =  emp.getEmpId();
			
				   
				   long end = new Date().getTime();
				   
				   System.out.println(Thread.currentThread().getName()+" took time : "+(end-start));
				   
				   return id;
				}
				
			});
			
			futlist.add(ft);
			if(futlist.size()==2) {
				break;
			}
			
		}
		
		for(Future<Integer> futu : futlist) {
			System.out.println(execComplServ.take().get());
		}
			
		exec.shutdown();
		exec.awaitTermination(10, TimeUnit.MILLISECONDS);
		
	}

}

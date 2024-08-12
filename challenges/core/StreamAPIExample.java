package challenges.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamAPIExample {
	
	public static void main(String[] args) {
		EmployeeDemo ed1 = new EmployeeDemo(100, "John", 10000, "computer");
		EmployeeDemo ed2 = new EmployeeDemo(400, "Cena", 40000, "admin");
		EmployeeDemo ed3 = new EmployeeDemo(300, "Dwayn", 30000, "hr");
		EmployeeDemo ed4 = new EmployeeDemo(500, "Sally", 50000, "facility");
		EmployeeDemo ed5 = new EmployeeDemo(200, "Kim", 20000, "learning");
		
		
		List<EmployeeDemo> emplist = Arrays.asList(ed1, ed2, ed3, ed4, ed5);
		
		List<EmployeeDemo> empListMoreSalary = emplist.stream().filter(emp -> emp.empId()>200).collect(Collectors.toList());
		
		//System.out.println(" employees id greater than 200 :: "+empListMoreSalary);
		
		List<String> empNames = emplist.stream().filter(emp -> emp.salary()>20000).map(EmployeeDemo :: empName).collect(Collectors.toList());
		
		//System.out.println(" employees salary greater than 20000 :: "+empNames);
		
		List<EmployeeDemo> sortedEmplist = emplist.stream().sorted(Comparator.comparing(EmployeeDemo :: empId)).collect(Collectors.toList());
		//System.out.println(" sorted employee list based on empId :: "+sortedEmplist);
		
		Map<Integer, EmployeeDemo> empMap = emplist.stream().filter(emp -> emp.empId()>300)
				.collect(Collectors.toMap(emp -> emp.empId(), Function.identity()));
		
		//System.out.println(" map is :::: "+empMap);
		
		String[][] starr = {{"B","A"}, {"D","E"}, {"C"}};
		
		Stream<String[]> st = Stream.of(starr);
		
		List<String> alist = st.flatMap(ar -> Arrays.stream(ar)).sorted().collect(Collectors.toList());
		//System.out.println(" flatten the string array ::: "+alist);
		
		
		
		EmployeeDemo e1 = new EmployeeDemo(100, "John", 10000, "computer");
		EmployeeDemo e2 = new EmployeeDemo(400, "Cena", 40000, "admin");
		EmployeeDemo e3 = new EmployeeDemo(300, "Dwayn", 30000, "hr");
		EmployeeDemo e4 = new EmployeeDemo(400, "Cena", 40000, "admin");
		EmployeeDemo e5 = new EmployeeDemo(100, "John", 10000, "computer");
		
		
		List<EmployeeDemo> emplist1 = Arrays.asList(e1, e2, e3, e4, e5);
		
		Set<String> hset = new HashSet<>();
		
		List<EmployeeDemo> nodDupEmpList = emplist1.stream().filter(emp -> hset.add(emp.empName())).collect(Collectors.toList());
		
		//System.out.println(" unique list :::: "+nodDupEmpList);
		
		Map<String, Integer> nmap = new HashMap<>();
		
		nmap.put("One", 1);
		nmap.put("Three", 3);
		nmap.put("Two", 2);
		nmap.put("Five", 5);
		nmap.put("Four", 4);
		
		System.out.println(" before sorting map :::: "+nmap);
		
		Map<String, Integer> smap = nmap.entrySet()
                .stream()
                .sorted((i1, i2)
                            -> i1.getValue().compareTo(
                                i2.getValue()))
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (en1, en2) -> en1, LinkedHashMap::new));
		
		System.out.println(" sorted map :::: "+smap);
		
		
		
		Map<String, Integer> newmap = new HashMap<>();
				
		        newmap.put("Three", 1);
				newmap.put("One", 3);
				newmap.put("Two", 2);
				newmap.put("Five", 5);
				newmap.put("Four", 4);
				
		System.out.println(" before sorting map :::: "+nmap);		
		
		
		Map<String, Integer> tmap = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return newmap.get(o1).compareTo(newmap.get(o2));
			}
			
		});
		
		tmap.putAll(newmap);
		
		System.out.println(" sorted map :::: "+tmap);
	}

}

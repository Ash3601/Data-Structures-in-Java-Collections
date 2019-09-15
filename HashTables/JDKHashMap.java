import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import EmployeeClass.Employee;

class JDKHashMap {
	public static void main(String args[]) {
		Map<String, Employee> hashMap = new HashMap<String, Employee>();

		Employee johnDoe = new Employee("John", "Doe", 126);
		Employee alisaRay = new Employee("Alisa", "Rayie", 210);
		Employee robertDoe = new Employee("Robert", "Doel", 352);
		Employee maxMill = new Employee("Max", "Mille", 752);
		Employee bradTrav = new Employee("Brad", "Traversy", 786);

		// put into hashMap
		hashMap.put("Doe", johnDoe);
		hashMap.put("Rayie", alisaRay);
		hashMap.put("Doel", robertDoe);
		hashMap.put("Mille", maxMill);
		// hashMap.put("Traversy", bradTrav);

		// printing our hashmap
		Iterator<Employee> iter = hashMap.values().iterator();

		// while(iter.hasNext()) {
		// 	System.out.println(iter.next());
		// }

		// Another way use for each
		hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));

		// check if hashMap contains the key
		System.out.println(hashMap.containsKey("Doel"));
		System.out.println(hashMap.containsValue(bradTrav));

		// lets put the employee with the same key
		// res would be that it will replace previous employee 
		// and will return it
		System.out.println(hashMap.put("Doe", johnDoe));

		// print list 
		System.out.println("print list ");
		hashMap.forEach((k, v) -> System.out.println(v));

		// to avoid above problem 
		// use putIfAbsent
		// it returns value at that position if its present
		hashMap.putIfAbsent("Doe", bradTrav);

		// print list 
		System.out.println("print list ");
		hashMap.forEach((k, v)->System.out.println(v));

		System.out.println("getting the values");		
		// get 
		System.out.println(hashMap.get("Doe"));

		System.out.println("getOrDefault");		
		// now if the value is not present get returns null
		// in order to return any other value use 
		// getOrDefault
		System.out.println(hashMap.getOrDefault("anything", maxMill));

		// remove
		System.out.println(hashMap.remove("Doe"));

		// Other NOTES

		// we also have
		// replace, putAll, ...
		// We also have LinkedHashMap
	}
}
import EmployeeClass.Employee;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Math;

class StoredEmployee {
	public String key;
	public Employee employee;


	public StoredEmployee(String key, Employee employee)
	{
		this.key = key;
		this.employee = employee;
	}
}

public class ChainedHashtables {

	private LinkedList<StoredEmployee>[] hashtable;

	// constructor 
	public ChainedHashtables() {
		hashtable = new LinkedList[10];
		for (int i=0; i<hashtable.length; i++) {
			hashtable[i] = new LinkedList<StoredEmployee>();
		}
	}

	// put method
	public void put(String key, Employee employee) {
		// hash the key
		int hashedKey = hashKey(key);	 
		hashtable[hashedKey].add(new StoredEmployee(key, employee));
	}

	// get method
	public Employee get(String key) {
		int hashedKey = hashKey(key);
		// Iterator iter = hashtable.iterator();
		ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
		StoredEmployee employee = null;
		while(iterator.hasNext()) {
			employee = iterator.next();	
			if (employee.key.equals(key)) {
				return employee.employee;
			}
		}

		// if not matched
		return null;
	}

	// remove method
	public Employee remove(String key) {
		int hashedKey = hashKey(key);
		// Iterator iter = hashtable.iterator();
		ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
		StoredEmployee employee = null;
		int foundIndex = -1;
		while(iterator.hasNext()) {
			employee = iterator.next();	
			foundIndex++;
			if (employee.key.equals(hashedKey)) {
				// return employee.employee;
				break;
			}
		}

		if (employee == null || !employee.key.equals(key)){
			return null;
		} else {
			hashtable[hashedKey].remove(foundIndex); 
			return employee.employee;
		}

	}

	// hashing function
	private int hashKey(String key) {
		return key.length() % hashtable.length;
		// OR
		// return Math.abs(key.hashCode() % hashtable.length);
	}

	// print hash table
	public void print () {
		for (int i=0; i<hashtable.length; i++) {
			// linked list is empty no iteration
			if (hashtable[i].isEmpty()) {
				System.out.println("Position " + i + ": empty");
			} else {
				System.out.print("Position " + i + " ");
				ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
				while (iterator.hasNext()){
					System.out.print(iterator.next().employee);
					// since its a doubly linked list
					System.out.print("<->");
				}
				System.out.println("null");
			}
		}
	}
}

class CHDemo {
	public static void main(String args[]) {
		Employee johnDoe = new Employee("John", "Doe", 126);
		Employee alisaRay = new Employee("Alisa", "Rayie", 210);
		Employee robertDoel = new Employee("Robert", "Doel", 352);
		Employee maxMill = new Employee("Max", "Mille", 752);
		Employee bradTrav = new Employee("Brad", "Traversy", 786);

		ChainedHashtables hashtable = new ChainedHashtables();

		// add to hashtable
		hashtable.put("Doe", johnDoe);
		hashtable.put("Rayie", alisaRay);
		hashtable.put("Doel", robertDoel);
		hashtable.put("Mille", maxMill);
		hashtable.put("Traversy", johnDoe);

		// print hashtable
		hashtable.print();

		System.out.println("Removing item");

		hashtable.remove("Mille");

		// print 
		hashtable.print();

		hashtable.remove("Rayie");

		// print 
		hashtable.print();

	}
}
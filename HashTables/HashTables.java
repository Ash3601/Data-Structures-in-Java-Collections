// Hash tables uses key value pairs
// It is used to search the item
// Uses a hash function to hash the key
// If two keys gets hashed to the same value its called as collision

import EmployeeClass.Employee;

class SimpleHashtable {
	// create a hash array
	private Employee[] hashtable;

	public SimpleHashtable() {
		hashtable = new Employee[10];
	}

	// hash function
	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}

	// put function to put values into the hash tables
	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);
		// if hash table already contains an employee
		// since we wont handle the collisions
		if (hashtable[hashedKey] != null) {
			System.out.println("Sorry, there's already an Employee at " + hashedKey);
		} else {
			// push an Employee into the hash array(hashtable)
			hashtable[hashedKey] = employee;
		}
	}

	// get the Employee from the hashtable
	public Employee get(String key) {
		return hashtable[this.hashKey(key)];
	}

	// print hashtables
	public void print() {
		for (int i=0; i<hashtable.length; i++) {
			System.out.println(hashtable[i]);
		}
	}

}

class HashTables {
	public static void main (String args[]) {
		Employee johnDoe = new Employee("John", "Doe", 126);
		Employee alisaRay = new Employee("Alisa", "Ray", 210);
		Employee robertDoe = new Employee("Robert", "Doel", 352);
		Employee maxMill = new Employee("Max", "Mill", 752);
		Employee bradTrav = new Employee("Brad", "Traversy", 786);

		// creating an object
		SimpleHashtable hashtable = new SimpleHashtable();

		// adding into hash
		hashtable.put(johnDoe.getLastName(), johnDoe);
		hashtable.put(alisaRay.getLastName(), alisaRay);
		hashtable.put(johnDoe.getLastName(), johnDoe);
		hashtable.put(maxMill.getLastName(), maxMill);
		hashtable.put(bradTrav.getLastName(), bradTrav);

		System.out.println("Printing the table");
		// print hashtable
		hashtable.print();

		System.out.println("Get the item");
		// get the item
		System.out.println(hashtable.get(bradTrav.getLastName()));
	}
}
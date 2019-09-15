// Hash tables uses key value pairs
// It is used to search the item
// Uses a hash function to hash the key
// If two keys gets hashed to the same value its called as collision

import EmployeeClass.Employee;

class StoredEmployee {
	public String key;
	public Employee employee;


	public StoredEmployee(String key, Employee employee)
	{
		this.key = key;
		this.employee = employee;
	}
}



class SimpleHashtable {
	// create a hash array
	private StoredEmployee[] hashtable;

	public SimpleHashtable() {
		hashtable = new StoredEmployee[10];
	}

	// hash function
	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}

	// put function to put values into the hash tables
	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);

		// linear probing
		if (isOccupied(hashedKey)) {
			// stop index means that when we check all the values after the hashed key
			// we start again from 0 then stop it to hashedKey
			int stopIndex = hashedKey;
			if (hashedKey == hashtable.length - 1){
				hashedKey = 0;
			} else 
				// increment hashedKey if something is present at that slot
				hashedKey++;
			// loop through all the items if slot is not empty
			while (isOccupied(hashedKey) && hashedKey != stopIndex){
				hashedKey = (hashedKey + 1) % hashtable.length; 
			}

		}
		// if hash table already contains an employee
		// since we wont handle the collisions
		if (isOccupied(hashedKey)) {
			System.out.println("Sorry, there's already an Employee at " + hashedKey);
		} else {
			// push an Employee into the hash array(hashtable)
			hashtable[hashedKey] = new StoredEmployee(key, employee);
		}
	}

	// get the Employee from the hashtable
	public Employee get(String key) {
		int hashedKey = findKey(key);
		if (hashedKey == -1)
			return null;
		return hashtable[hashedKey].employee;
	}

	private int findKey(String key) {
		int hashedKey = hashKey(key);
		if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)){
			return hashedKey;
		}

		// linear probing
		// if (isOccupied(hashedKey)) {
			// stop index means that when we check all the values after the hashed key
			// we start again from 0 then stop it to hashedKey
			int stopIndex = hashedKey;
			if (hashedKey == hashtable.length - 1){
				hashedKey = 0;
			} else 
				// increment hashedKey if something is present at that slot
				hashedKey++;
			// loop through all the items if slot is not empty
			while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)){
				hashedKey = (hashedKey + 1) % hashtable.length; 
			}

			if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)){
				return hashedKey;
			} else 
				return -1;

			// if (stopIndex == hashedKey)
			// 	return -1;
			// else 
			// 	return hashedKey;

		// }

	}

	// remove method
	public Employee remove(String key) {
		int hashedKey = findKey(key);
		if (hashedKey == -1)
			return null;
		Employee employee = hashtable[hashedKey].employee;
		hashtable[hashedKey] = null;
		return employee;
	}

	// isOccupied
	private boolean isOccupied(int index) {
		return this.hashtable[index] != null;
	}

	// print hashtables
	public void print() {
		for (int i=0; i<hashtable.length; i++) {
			if (hashtable[i] == null)
				System.out.println("empty");
			else
				System.out.println(hashtable[i].employee);
		}
	}

}

class Hashtables2 {
	public static void main (String args[]) {
		Employee johnDoe = new Employee("John", "Doe", 126);
		Employee alisaRay = new Employee("Alisa", "Rayie", 210);
		Employee robertDoe = new Employee("Robert", "Doel", 352);
		Employee maxMill = new Employee("Max", "Mille", 752);
		Employee bradTrav = new Employee("Brad", "Traversy", 786);

		// creating an object
		SimpleHashtable hashtable = new SimpleHashtable();

		// adding into hash
		hashtable.put(johnDoe.getLastName(), johnDoe);
		hashtable.put(alisaRay.getLastName(), alisaRay);
		hashtable.put(johnDoe.getLastName(), bradTrav);
		hashtable.put(maxMill.getLastName(), maxMill);
		// hashtable.put(bradTrav.getLastName(), bradTrav);

		System.out.println("Printing the table");
		// print hashtable
		hashtable.print();

		// System.out.println("Get the item");
		// get the item
		System.out.println("Get the item " + hashtable.get("Rayie"));
		System.out.println("Get the item " + hashtable.get("Mille"));

		System.out.println("Removing items");
		hashtable.remove("Rayie");
		System.out.println("Printing the table");
		// print hashtable
		hashtable.print();
	}
}
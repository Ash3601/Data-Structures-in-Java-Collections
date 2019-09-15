import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

class Employee {
	private String firstName;
	private String lastName;
	private int id;

	// Setting up the constructor
	public Employee (String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id; 
	}

	// Creating getters and setters
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}

	public void setLastName (String lastName) {
		this.lastName = lastName;
	}

	public void setId (int id) {
		this.id = id;
	}	

	public String getFirstName (String firstName) {
		return this.firstName;
	}

	public String getLastName (String lastName) {
		return this.lastName;
	}

	public int getId (int id) {
		return this.id;
	}

	@Override
	public String toString () {
		return "Employee {" + 
		"firstName='" + firstName + '\'' +
		", lastName='" + lastName + '\'' +
		", id='" + id + '\'' +
		'}';

	}

	// Implementing the equals method for contains problem
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.firstName);
        hash = 71 * hash + Objects.hashCode(this.lastName);
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}

class ArrayListTest {
	public static void main (String args[]) {

		List <Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Robert", "Doel", 1));
		employeeList.add(new Employee("John", "Doe", 2));
		employeeList.add(new Employee("Anna", "Williams", 3));

		// Using forEach and lamda expession
		employeeList.forEach(employee -> System.out.println(employee));

		// using the get method to retrieve the index of the employee object
		System.out.println (employeeList.get(1));

		// Checking if the list is empty
		System.out.println (employeeList.isEmpty());

		// changing the value of the objects in the list
		employeeList.set(1, new Employee("John", "Maria", 211));

		// Printing list again. For fun!! :)
		employeeList.forEach(employee -> System.out.println(employee));

		// Get the items in the list
		System.out.println (employeeList.size());

		// Adding the object at a specified location
		// Note: Here all the arrays needs to be shifted down
		employeeList.add(1, new Employee("John", "Doe", 2));

		// Printing list again
		employeeList.forEach (employee -> System.out.println(employee));
		
		System.out.println ("\n\nPrinting the Employee Array\n\n");

		// Converting the employeeList to employeeArray
		// The employeeArray should be of type Employee Array
		Employee [] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);

		// Printing the employee array
		for (Employee employee : employeeArray)	{
			System.out.println (employee);
		}

		// Checking if the particular type of element is present in the array
		// Use contains
		// NOTE: The below code returns false even though it is present in the arrayList
		// These both are different instances
		// So we need to implement an equals method that may check each value of these 
		// two instances
		System.out.println (employeeList.contains(new Employee("John", "Doe", 2)));

		// Similialry our equals function works like that
		Employee emp1 = new Employee ("Abc", "asd", 23);
		System.out.println (emp1.equals(new Employee("Abc", "asd", 23)));

		// Using indexOf to get the index of the object
		System.out.println (employeeList.indexOf(new Employee("John", "Doe", 2)));

		// Remove items from the list 
		// Remove at position 2 for example
		// Elements needs to be shifted down the position
		employeeList.remove(2);
		employeeList.forEach (employee -> System.out.println (employee));
	}
}
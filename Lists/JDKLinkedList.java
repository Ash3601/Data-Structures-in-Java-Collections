import EmployeeClass.Employee;
import java.util.LinkedList;
import java.util.Iterator;

class JDKLinkedList {
	public static void main (String args[]) {
		// Linked list is the doubly linked list
		LinkedList<Employee> list = new LinkedList<>();

		// list.add(new Employee("Aaron", "Stark", 21));
		// list.add(new Employee("Arya", "Stark", 11));
		// list.add(new Employee("Mitchell", "Stark", 245));
		// list.add(new Employee("Robert", "Baratheon", 121));

		// Adding to the front of the linked list
		list.addFirst(new Employee("Aaron", "Stark", 21));
		list.addFirst(new Employee("Arya", "Stark", 11));
		list.addFirst(new Employee("Mitchell", "Stark", 245));
		list.addFirst(new Employee("Robert", "Baratheon", 121));

		// Printing list
		list.forEach(employee -> System.out.println (employee));

		// Printing using iterable
		Iterator iter = list.iterator();
		System.out.print ("HEAD -> ");
		while (iter.hasNext()) {
			System.out.print(iter.next());
			System.out.print(" <=> ");
		}
		System.out.println ("null");

		// Adding item to the end
		// Simply use the add method
		// Or use addLast
		list.add(new Employee ("George", "Bull", 291));

		// Print
		list.forEach(employee -> System.out.println(employee));

		System.out.println("Removing the elements");

		// Removing first and last element
		list.removeFirst();

		// Print
		iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println (iter.next());
		}

		System.out.println ("Remove last element");
		// Remove last element
		list.removeLast();

		// Print
		iter = list.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
	}

}
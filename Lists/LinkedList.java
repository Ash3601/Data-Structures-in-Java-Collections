
// The Employee class is imported from the package
// Named EmployeeClass
import EmployeePackage.Employee;

class EmployeeNode {
	private Employee employee;
	private EmployeeNode next;

	// Constructor
	public EmployeeNode (Employee employee) {
		this.employee = employee;
	}

	// Getter & Setter
	public void setEmployee (Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee () {
		return this.employee;
	}

	public EmployeeNode getNext () {
		return this.next;
	}

	public void setNext (EmployeeNode next) {
		this.next = next;
	}

	@Override 
	public String toString () {
		return employee.toString();
	}
}

class EmployeeLinkedList {
	private EmployeeNode head;
	private int size;
	// Add node 
	public void addToFront (Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		node.setNext(head);
		head = node;
		this.size++;
	}

	// Remove node
	public EmployeeNode removeFrontNode () {
		// Check if list is empty
		if (this.isListEmpty()) {
			return null;
		}
		EmployeeNode removedNode = head;

		this.head = this.head.getNext();
		this.size--;
		removedNode.setNext(null);
		return removedNode;
	}

	// Remove multiple nodes
	public EmployeeNode removeFrontNode (int n) {
		// Check if list is empty
		if (this.isListEmpty()) {
			return null;
		}
		int count = 0;
		while (count != n) {
			this.head = this.head.getNext();
			this.size--;
			count++;
			
		}
		return this.head;
	}


	// Print list
	public void printList () {
		EmployeeNode current = head;

		System.out.print ("HEAD -> ");

		while (current != null) {
			System.out.print (current);
			System.out.print (" -> ");
			current = current.getNext();
		}
		System.out.println ("null");
	}


	// Get list size
	public int getSize () {
		return (size);
	}

	// check if list is empty
	public boolean isListEmpty () {
		return head == null; 
	}

}

class LinkedListTest {
	public static void main (String args []) {
		EmployeeLinkedList el = new EmployeeLinkedList();
		el.addToFront(new Employee("Johnson", "Smith", 9));
		el.addToFront(new Employee("John", "Doe", 9));
		el.addToFront(new Employee("Robert", "Doel", 9));

		// Get size
		System.out.println (el.getSize());

		el.printList();

		el.removeFrontNode();

		el.printList();

		// System.out.println (el.removeFrontNode().getNext());

		// Get the size of the linked list
		System.out.println (el.getSize());

		// Check if list is empty
		EmployeeLinkedList el2 = new EmployeeLinkedList();
		System.out.println(el2.isListEmpty());

		// Remove multiple nodes
		el.removeFrontNode(2);

		el.printList();
	}
}
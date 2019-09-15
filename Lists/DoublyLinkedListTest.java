import EmployeeClass.Employee;

class EmployeeNode {
	private Employee employee;
	private EmployeeNode next;
	private EmployeeNode prev;

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

	public void setPrev (EmployeeNode prev) {
		this.prev = prev;
	}

	public EmployeeNode getPrev () {
		return this.prev;
	}

	@Override 
	public String toString () {
		return employee.toString();
	}

}

class EmployeeDoublyLinkedList {
	private EmployeeNode head;
	private EmployeeNode tail;
	private int size;

	public void addToFront (Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		node.setNext(head);
		
		// If head is null then we need to correctly set tail
		if (head == null)
			tail = node;
		else
			head.setPrev(node);
		head = node;
		size++;
	}

	// Add to end
	public void addToEnd (Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		node.setNext (null);
		if (tail == null) {
			head = node;
		}
		else {
			node.setPrev(tail);
			tail.setNext(node);
		}
		tail = node;
		size++;
	}

	// Print list
	public void printList () {
		EmployeeNode current = head;

		System.out.print ("HEAD -> ");

		while (current != null) {
			System.out.print (current);
			System.out.print (" <=> ");
			current = current.getNext();
		}
		System.out.println ("null");
	}

	// Remove Front node
	public EmployeeNode removeFront() {

		if (this.isEmpty())
			return null;

		EmployeeNode currentNode;
		currentNode = this.head;

		// If there is the only node that we are removing
		if (head.getNext() == null) {
			tail = null;
		} else {
			head.getNext().setPrev(null);
		}
		head = head.getNext();
		size--;
		currentNode.setNext(null);
		return currentNode;
	}

	// Remove last node
	public EmployeeNode removeEndNode() {

		if (this.isEmpty())
			return null;

		EmployeeNode currentTail;
		currentTail = tail;

		if (tail.getPrev() == null){
			head = null;
		} else {
			tail.getPrev().setNext(null);
		}
		
		tail = currentTail.getPrev();
		currentTail.setPrev(null);
		size--;
		return currentTail;
	}

	// Is list empty
	public boolean isEmpty () {
		return (this.head == null || this.tail == null);
	}

	// Get size of doubly linked list
	public int getSize () {
		return this.size;
	}

	// Get tail 
	public EmployeeNode getTail () {
		return this.tail;
	}

	// Get head
	public EmployeeNode getHead () {
		return this.head;
	}
}

class DLl {
	public static void main (String args []) {
		EmployeeDoublyLinkedList dll = new EmployeeDoublyLinkedList();
		dll.addToFront(new Employee("Jane", "Johns", 21));
		dll.addToFront(new Employee("Robert", "Doel", 211));
		dll.addToFront(new Employee("Christina", "Smith", 41));
		dll.printList();
		System.out.println (dll.getSize());

		// Add to the end
		dll.addToEnd(new Employee("Leonardo", "Smith", 31));
		dll.printList();

		// Removing front node
		dll.removeFront();

		dll.printList();

		System.out.println(dll.isEmpty());

		EmployeeDoublyLinkedList dll2 = new EmployeeDoublyLinkedList();
		System.out.println (dll2.isEmpty());
		dll2.removeFront();

		// Remove end node
		dll.removeEndNode();
		dll.printList();
		System.out.println(dll.getTail());

		System.out.println(dll.getHead());

		// Removing the only element
		dll2.addToEnd(new Employee("asd", "dsa", 23));

		dll2.removeFront();
		dll2.printList();
	}
}
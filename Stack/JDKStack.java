// Java docs recommend not to use Stack 
// Instead its better to use linked list as Stack

// Linked list class also contains pop push peek methods 
// Linked list is also interfaces the Deque class

import EmployeeClass.Employee;
import java.util.LinkedList;
import java.util.Iterator;
class LinkedStack {

		private LinkedList<Employee> stack;

		// Constructor
		LinkedStack () {
			this.stack = new LinkedList<Employee>();
		}

		// push
		public void push (Employee employee) {
			this.stack.push(employee);
		}

		// pop
		public Employee pop () {
			return this.stack.pop();
		}

		// peek
		public Employee peek () {
			return this.stack.peek();
		}

		// isEmpty
		public boolean isEmpty() {
			return this.stack.isEmpty();
		}

		// list iterator
		public void printStack () {
			Iterator iter = this.stack.iterator();
			while (iter.hasNext()) {
				System.out.println(iter.next());
			}
		}
}

class JDKStack {
	public static void main (String args[]) {
		Employee emp = new Employee("Employ", "sdsf", 23);
		Employee emp1 = new Employee("Employ1", "sdsf", 23);
		Employee emp2 = new Employee("Employ2", "sdsf", 23);
		Employee emp3 = new Employee("Employ3", "sdsf", 23);
		Employee emp4 = new Employee("Employ4", "sdsf", 23);
		Employee emp5 = new Employee("Employ5", "sdsf", 23);
		Employee emp6 = new Employee("Employ6", "sdsf", 23);

		LinkedStack ls = new LinkedStack();
		ls.push(emp);
		ls.push(emp1);
		ls.push(emp2);
		ls.push(emp3);

		// print stack
		ls.printStack();
	}
}
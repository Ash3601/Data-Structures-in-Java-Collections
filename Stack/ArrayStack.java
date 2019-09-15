import EmployeeClass.Employee;
import java.util.EmptyStackException;
class ArrayStack {
	private Employee[] stack;
	private int top;

	public ArrayStack(int capacity) {
		this.stack = new Employee[capacity];
	}

	public void push (Employee employee) {
		if (top == this.stack.length) {

			System.out.println ("Stack will now be resized with the capacity of " + (2*stack.length));
			// Resizing to hold double the elements
			Employee [] newArray = new Employee [2 * stack.length];
			System.arraycopy(stack, 0, newArray, 0, stack.length);
			stack = newArray;
		}
		stack[top++] = employee;
	}

	// Pop
	public Employee pop () {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		Employee employee = stack[--top];
		stack[top] = null;
		return employee;
	}

	// Pop multiple items
	public Employee pop (int numberToPop) {
		int count = 0;
		while (count != numberToPop) {
			if (isEmpty()) {
				throw new EmptyStackException();
			}
			// Employee employee = stack[--top];
			--top;
			count++;
		}
		Employee employee = stack[top];
		stack[top] = null;

		// System.out.println("Returened employee in multipop");
		// System.out.println(employee);
		return employee;
	}

	//peek
	public Employee peak() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return this.stack[this.top - 1];
	}

	// Is empty
	public boolean isEmpty () {
		return (top == 0);
	}

	// Stack items
	public int stackItems () {
		return this.top;
	}

	// Print Stack
	public void printStack () {
		for (int i=this.top - 1; i >= 0; i--) {
			System.out.println(stack[i]);
		}
	}

	
}

class Demo {
	public static void main (String args[]) {
		ArrayStack stack = new ArrayStack(5);
		Employee emp = new Employee("Employ", "sdsf", 23);
		Employee emp1 = new Employee("Employ1", "sdsf", 23);
		Employee emp2 = new Employee("Employ2", "sdsf", 23);
		Employee emp3 = new Employee("Employ3", "sdsf", 23);
		Employee emp4 = new Employee("Employ4", "sdsf", 23);
		Employee emp5 = new Employee("Employ5", "sdsf", 23);
		Employee emp6 = new Employee("Employ6", "sdsf", 23);

		stack.push(emp);
		stack.push(emp1);
		stack.push(emp2);
		stack.push(emp3);
		stack.push(emp4);
		stack.push(emp5);
		stack.printStack();
		System.out.println (stack.stackItems());

		// Pop 
		stack.pop();

		// print
		stack.printStack();

		System.out.println("Remove multiple");
		// Pop multiple
		stack.pop(2);

		// Print
		stack.printStack();
	}
}


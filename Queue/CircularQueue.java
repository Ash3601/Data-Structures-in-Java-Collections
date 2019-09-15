import java.util.NoSuchElementException;
import EmployeeClass.Employee;

public class CircularQueue {

    private Employee[] queue;
    private int front;
    private int back;

    public CircularQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if (size() == queue.length - 1) {
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }

        // 0   jane
        // 1    john
        // 2  -   -back
        // 3  -mike - front
        // 4   -bill

        // 0 mike
        // 1 bill
        // 2 jane
        // 3 john
        // 4 - back
        // 5
        // 9


        queue[back] = employee;
        if (back < queue.length - 1) {
            back++;
        }
        else {
            back = 0;
        }
    }

    public Employee remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];
        queue[front] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        } else if (front == queue.length){
        	front = 0;
        }

        return employee;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size() {
    	if (front >= back)
        	return back - front;
        else 
        	return back - front + queue.length;
    }

    public void printQueue() {
    	if (front >= back) {
	        for (int i = front; i < back; i++) {
 			   System.out.println(queue[i]);
			}
    	} else {
    		for (int i=front; i<queue.length; i++)
    			System.out.println(queue[i]);
    		for (int i=0; i<back; i++)
    			System.out.println(queue[i]);

    		
    	}
    }

    public int queueSize() {
    	return this.queue.length;
    }

}

class Main {
	public static void main (String args[]) {
        Employee emp = new Employee("Employ", "sdsf", 23);
        Employee emp1 = new Employee("Employ1", "sdsf", 24);
        Employee emp2 = new Employee("Employ2", "sdsf", 54);
        Employee emp3 = new Employee("Employ3", "sdsf", 212);
        Employee emp4 = new Employee("Employ4", "sdsf", 25);
        Employee emp5 = new Employee("Employ5", "sdsf", 26);
        Employee emp6 = new Employee("Employ6", "sdsf", 28);

        CircularQueue queue = new CircularQueue(3);

        // add employees 
        queue.add(emp);
        queue.add(emp1);

        queue.remove();

        queue.add(emp);
        queue.remove();

        queue.add(emp);
        queue.remove();

        queue.add(emp);
        queue.remove();

        queue.add(emp);
        queue.remove();

        System.out.println("Size of queue now is " + queue.size());
        System.out.println("Size of queue now is " + queue.queueSize());

	}
}
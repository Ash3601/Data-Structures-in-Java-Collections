import EmployeeClass.Employee;
import java.util.NoSuchElementException;

public class ArrayQueue {
    // Its disadvantage is if we add an item and remove and then again add
    // Then queue size will increase that should not happen
    // For that we implement Circular Queue
    private Employee[] queue;
    private int front, back;

    // Constructor
    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    // add method
    public void add(Employee employee) {
        // It will prevent out of bound condition by increasing the size of the array
        if (back == queue.length) {
            // WARNING
            System.out.print("Increasing the size of the queue ");
            System.out.println("to " + 2*this.size());
            Employee [] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }
        
        // Add procedure
        queue[back++] = employee;
    }

    // remove method
    // when first item is added back = 1 front = 0
    public Employee remove() {
        // means the queue is empty
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];
        
        // Delete the data of employee also
        queue[front] = null;

        front++;
        // if the only element remaining is removed we can reset front and back 
        // to original posns i.e 0
        if (size() == 0){
            front = back = 0;
        }

        return employee;
    }

    // size
    public int size() {
        return (back - front);
    }

    // peek
    public Employee peek() {
        // if queue is empty
        if (size() == 0){
            throw new NoSuchElementException();
        }
        return queue[front];
    }
    // print queue
    public void printQueue() {
        // since back points to the next available position
        // thus print upto back - 1
        for (int i = front; i<back; i++) {
            System.out.println(queue[i]);
        }
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

        // create queue
        ArrayQueue queue = new ArrayQueue(5);

        // add employees 
        queue.add(emp);
        queue.add(emp1);
        queue.add(emp2);
        queue.add(emp3);
        queue.add(emp4);

        // print queue
        queue.printQueue();

        // Adding more than capacity
        queue.add(emp5);

        // Printing queue
        queue.printQueue();

        // removing items
        queue.remove();

        System.out.println("Print queue below: ");
        // print
        queue.printQueue();

        // print queue size
        System.out.println("Queue Size");
        System.out.println(queue.size());

        // removing all the elements
        for (int i=0; i<queue.size(); i++){
            queue.remove();
        }

        System.out.println("Print queue below: ");

        // print
        queue.printQueue();

        // remove one more
        queue.remove();
        System.out.println("Print queue below: ");
        queue.printQueue();

        // remove one more
        queue.remove();
        System.out.println("Print queue below: ");
        queue.printQueue();

        // remove one more
        queue.remove();
        System.out.println("Print queue below: ");
        queue.printQueue();
    }
}
import EmployeeClass.Employee;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

class JDKQueue {
	public static void main (String args []) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		Iterator iter = q.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
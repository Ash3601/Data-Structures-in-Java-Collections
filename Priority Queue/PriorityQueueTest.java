import java.util.PriorityQueue;

class PriorityQueueTest {
	public static void main(String args[]) {

		// in jdk its a min heap 

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		pq.add(25);
		pq.add(-22);
		pq.add(1343);
		pq.add(54);
		pq.add(0);
		pq.add(-3429);
		pq.add(429);

		System.out.println(pq.peek());
		System.out.println(pq.remove());
		System.out.println(pq.peek());


		System.out.println("Array");
		// LETS PRINT OUR LIST
		pq.forEach((value)->System.out.println(value));
	}
}
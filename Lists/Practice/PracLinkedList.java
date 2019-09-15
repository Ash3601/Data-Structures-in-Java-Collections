class Node {
	private int data;
	private Node next;

	// Getter & Setters
	public Node getNext () {
		return this.next;
	}

	public void setNext (Node next) {
		this.next = next;
	}

	public int getData () {
		return this.data;
	}

	public void setData (int data) {
		this.data = data;
	}
}

class Linked_List {
	private Node head;

	public void addToFront (int data) {
		Node node = new Node ();
		node.setData (data);
		node.setNext(head);
		head = node;
	}

	// Print list 
	public void printList () {
		Node current;
		current = this.head;
		System.out.print ("HEAD -> ");
		while (current != null) {
			System.out.print (current.getData());
			System.out.print (" -> ");
			current = current.getNext();
		}
		System.out.print ("null");

	}
}

class PracLinkedList {
	public static void main (String args []) {
		Linked_List ll = new Linked_List();
		ll.addToFront(3);
		ll.addToFront(1);
		ll.addToFront(4);
		ll.addToFront(6);
		ll.addToFront(7);
		ll.printList();
	}
}
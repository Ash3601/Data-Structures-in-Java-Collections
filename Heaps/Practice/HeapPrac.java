class Heap {
	private int[] heap;
	private int size;

	public Heap (int capacity) {
		heap = new int[capacity];
	}

	// insert
	public void insert(int value) {
		if (heap.length == size) {
			throw new IndexOutOfBoundsException("Heap is full");
		}

		heap[size] = value;
		// pass in index of the new element
		heapifyAbove(size++);
	}

	// heapify above method
	public void heapifyAbove(int index) {
		// check if the parent value is less than the child value 
		// in bottom up manner
		int newValue = heap[index];
		// index > 0 index is not root
		// since if its a root we dont need to check it, just insert it
		while (newValue > heap[getParent(index)] && index > 0) {
			heap[index] = heap[getParent(index)];
			index = getParent(index);
		}

		heap[index] = newValue;


	}

	// get parent index 
	public int getParent(int index) {
		return (index - 1) / 2;
	}

	// print heap
	public void print() {
		// for (int i=0; )
		for (int i = 0; i < size; i++) {
            System.out.print(this.heap[i]);
            System.out.print(", ");
        }
	}

}

class HeapPrac {
	public static void main(String args[]) {

		Heap heap = new Heap(5);
		heap.insert(10);
		heap.insert(2);
		heap.insert(3);
		heap.insert(9);

		// print
		heap.print();
	}
}